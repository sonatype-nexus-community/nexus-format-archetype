/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) ${currentYear}-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package $ import javax.inject.Named;

{package}.${pluginFormat}.internal.security;

/**
 * ${pluginClass} format security facet.
 */
@Named
public class ${pluginClass}SecurityFacet
    extends SecurityFacetSupport
{
  @Inject
  public ${pluginClass}SecurityFacet(final ${pluginClass}FormatSecurityContributor securityResource,
                            @Named("simple") final VariableResolverAdapter variableResolverAdapter,
                            final ContentPermissionChecker contentPermissionChecker)
  {
    super(securityResource, variableResolverAdapter, contentPermissionChecker);
  }

  @Override
  protected void doValidate(final Configuration configuration) throws Exception {
    super.doValidate(configuration);
  }
}