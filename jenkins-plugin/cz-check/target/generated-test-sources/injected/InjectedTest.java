import java.util.*;
/**
 * Entry point to auto-generated tests (generated by maven-hpi-plugin).
 * If this fails to compile, you are probably using Hudson &lt; 1.327. If so, disable
 * this code generation by configuring maven-hpi-plugin to &lt;disabledTestInjection&gt;true&lt;/disabledTestInjection&gt;.
 */
public class InjectedTest extends junit.framework.TestCase {
  public static junit.framework.Test suite() throws Exception {
    System.out.println("Running tests for "+"org.jenkins:cz-check:1.0-SNAPSHOT");
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("basedir","D:\\work\\2021G1\\jenkins-plugin\\cz-check");
    parameters.put("artifactId","cz-check");
    parameters.put("packaging","hpi");
    parameters.put("outputDirectory","D:\\work\\2021G1\\jenkins-plugin\\cz-check\\target\\classes");
    parameters.put("testOutputDirectory","D:\\work\\2021G1\\jenkins-plugin\\cz-check\\target\\test-classes");
    parameters.put("requirePI","true");
    return org.jvnet.hudson.test.PluginAutomaticTestBuilder.build(parameters);
  }
}