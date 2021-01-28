
package org.sonar.samples.java;

import org.sonar.api.Plugin;

public class MyJavaRulesPlugin implements Plugin {

  @Override
  public void define(Context context) {

    context.addExtension(MyJavaRulesDefinition.class);
    context.addExtension(MyJavaFileCheckRegistrar.class);

  }

}
