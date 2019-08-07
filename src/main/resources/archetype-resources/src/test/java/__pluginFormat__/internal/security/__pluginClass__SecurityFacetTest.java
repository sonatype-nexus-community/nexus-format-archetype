/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) ${current.year}-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package ${package}.${pluginFormat}.internal.security;

public class ${pluginClass}SecurityFacetTest
    extends TestSupport
{
  @Mock
  Request request;

  @Mock
  Repository repository;

  @Mock
  ContentPermissionChecker contentPermissionChecker;

  @Mock
  VariableResolverAdapter variableResolverAdapter;

  @Mock
  ${pluginClass}FormatSecurityContributor securityContributor;

  ${pluginClass}SecurityFacet ${pluginFormat}SecurityFacet;

  @Before
  public void setupConfig() throws Exception {
    when(request.getPath()).thenReturn("/some/path.txt");
    when(request.getAction()).thenReturn(HttpMethods.GET);

    when(repository.getFormat()).thenReturn(new Format("${pluginFormat}") { });
    when(repository.getName()).thenReturn("${pluginClass}SecurityFacetTest");

    ${pluginFormat}SecurityFacet = new ${pluginClass}SecurityFacet(securityContributor,
        variableResolverAdapter, contentPermissionChecker);

    ${pluginFormat}SecurityFacet.attach(repository);
  }

  @Test
  public void testEnsurePermitted_permitted() throws Exception {
    when(contentPermissionChecker.isPermitted(eq("${pluginClass}SecurityFacetTest"), eq("${pluginFormat}"), eq(READ), any()))
        .thenReturn(true);
    ${pluginFormat}SecurityFacet.ensurePermitted(request);
  }

  @Test
  public void testEnsurePermitted_notPermitted() throws Exception {
    when(contentPermissionChecker.isPermitted(eq("${pluginClass}SecurityFacetTest"), eq("${pluginFormat}"), eq(READ), any()))
        .thenReturn(false);
    try {
      ${pluginFormat}SecurityFacet.ensurePermitted(request);
      fail("AuthorizationException should have been thrown");
    }
    catch (AuthorizationException e) {
      //expected
    }

    verify(contentPermissionChecker).isPermitted(eq("${pluginClass}SecurityFacetTest"), eq("${pluginFormat}"), eq(READ), any());
  }
}
