/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2019-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package ${package}.${pluginFormat}.internal;

public class ${pluginClass}ProxyIT
    extends ${pluginClass}ITSupport
{
  private static final String TEST_PATH = "some/valid/path/for/${pluginFormat}/remote/repo";

  private ${pluginClass}Client proxyClient;

  private Repository proxyRepo;

  @Configuration
  public static Option[] configureNexus() {
    return NexusPaxExamSupport.options(
        NexusITSupport.configureNexusBase(),
        nexusFeature("org.sonatype.nexus.plugins", "${rootArtifactId}")
    );
  }

  @Test
  public void unresponsiveRemoteProduces404() throws Exception {
    Server server = Server.withPort(0).serve("/*")
        .withBehaviours(error(HttpStatus.NOT_FOUND))
        .start();
    try {
      proxyRepo = repos.create${pluginClass}Proxy("${pluginFormat}-test-proxy-notfound", server.getUrl().toExternalForm());
      proxyClient = ${pluginFormat}Client(proxyRepo);
      MatcherAssert.assertThat(FormatClientSupport.status(proxyClient.get(TEST_PATH)), is(HttpStatus.NOT_FOUND));
    }
    finally {
      server.stop();
    }
  }

  @Test
  public void retrieve${pluginClass}WhenRemoteOffline() throws Exception {
    Server server = Server.withPort(0).serve("/*")
        .withBehaviours(content("Response"))
        .start();
    try {
      proxyRepo = repos.create${pluginClass}Proxy("${pluginFormat}-test-proxy-offline", server.getUrl().toExternalForm());
      proxyClient = ${pluginFormat}Client(proxyRepo);
      proxyClient.get(TEST_PATH);
    }
    finally {
      server.stop();
    }
    assertThat(status(proxyClient.get(TEST_PATH)), is(200));
  }
}
