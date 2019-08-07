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

/*global Ext, NX*/

/**
 * Foo plugin strings.
 */
Ext.define('NX.foo.app.PluginStrings', {
  '@aggregate_priority': 90,

  singleton: true,
  requires: [
    'NX.I18n'
  ],

  keys: {
    Repository_Facet_FooFacet_Title: 'Foo Settings',
    SearchFoo_Group: 'Foo Repositories',
    SearchFoo_License_FieldLabel: 'License',
    SearchFoo_Text: 'Foo',
    SearchFoo_Description: 'Search for components in Foo repositories',
  }
}, function(self) {
  NX.I18n.register(self);
});
