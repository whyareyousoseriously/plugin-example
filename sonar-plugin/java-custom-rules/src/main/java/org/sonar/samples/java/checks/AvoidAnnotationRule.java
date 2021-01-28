
package org.sonar.samples.java.checks;

import java.io.IOException;
import java.util.List;

import org.sonar.api.batch.fs.InputFile;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

@Rule(key = "AvoidAnnotation")
public class AvoidAnnotationRule extends BaseTreeVisitor implements JavaFileScanner {

    private JavaFileScannerContext context;


    @RuleProperty(defaultValue = "injectName")
    protected String name = "Zuper";

    private String fileName;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
        if (context.getInputFile().isFile()) {
            InputFile file = context.getInputFile();

            fileName = file.filename();
            if ("pom.xml".equals(fileName)) {
                try {
                    String contents = file.contents();

                    /***
                     * context.reportIssue最后的message就是扫描的结果
                     */
                    //context.reportIssue(this, context.getTree(), "ddddddd");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Override
    public void visitMethod(MethodTree tree) {
        System.out.println("tree simple name:" + tree.simpleName().name());
        List<AnnotationTree> annotations = tree.modifiers().annotations();

        for (AnnotationTree annotationTree : annotations) {

            if (annotationTree.annotationType().is(Tree.Kind.IDENTIFIER)) {
                IdentifierTree idf = (IdentifierTree) annotationTree.annotationType();
                /**
                 * 可用来做解析是否有注解
                 */
                if (idf.name().equals(name)) {
                    context.reportIssue(this, idf, String.format("Avoid using annotation @%s", name));
                }
            }
        }

        super.visitMethod(tree);
    }
}
