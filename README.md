# nexus-format-archetype

<!--
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.sonatype.nexus.archetypes/nexus-format-archetype/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.sonatype.nexus.archetypes/nexus-format-archetype)
-->
[Maven Central - Snapshot](https://repository.sonatype.org/content/repositories/snapshots/org/sonatype/nexus/archetypes/nexus-format-archetype/)


[![Build Status](https://travis-ci.org/sonatype-nexus-community/nexus-format-archetype.svg?branch=master)](https://travis-ci.org/sonatype-nexus-community/nexus-format-archetype) 
[![Join the chat at https://gitter.im/sonatype/nexus-developers](https://badges.gitter.im/sonatype/nexus-developers.svg)](https://gitter.im/sonatype/nexus-developers?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![DepShield Badge](https://depshield.sonatype.org/badges/sonatype-nexus-community/nexus-format-archetype/depshield.svg)](https://depshield.github.io)

Archetype for creating Nexus format plugin with a _lot_ of the boilerplate required to start development already created.

## How to create a format
Once the code has been checked out.

Build the archetype:

    mvn clean install

Change directory to a new folder where you wish to generate the format boilerplate code.
 
Generating a format plugin is as easy as running the following:
     
    mvn archetype:generate                              \ 
      -DarchetypeArtifactId=nexus-format-archetype      \
      -DarchetypeGroupId=org.sonatype.nexus.archetypes  \
      -DarchetypeVersion=1.0-SNAPSHOT                   \
      -DgroupId=org.sonatype.nexus.repository           \
      -DartifactId=nexus-repository-foo                 \
      -DpluginFormat=foo                                \
      -DpluginClass=Foo                                 \
      -Dversion=0.0.1

Repeated for the "newline" challenged:

    mvn archetype:generate -DarchetypeArtifactId=nexus-format-archetype -DarchetypeGroupId=org.sonatype.nexus.archetypes -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=org.sonatype.nexus.repository -DartifactId=nexus-repository-foo -DpluginFormat=foo -DpluginClass=Foo -Dversion=0.0.1
    
Optional parameters can be omitted. A shorter example using default parameter values:

    mvn archetype:generate -DarchetypeArtifactId=nexus-format-archetype -DarchetypeGroupId=org.sonatype.nexus.archetypes -DarchetypeVersion=1.0-SNAPSHOT -DpluginFormat=foo -DpluginClass=Foo

#### Required parameters:

Coordinates of the archetype:

**archetypeArtifactId** = _Must be:_ nexus-format-archetype

**archetypeGroupId** = _Must be:_ org.sonatype.nexus.archetypes

**archetypeVersion** = _The version of this archetype_ (e.g. 1.0-SNAPSHOT)

It is recommended to keep the naming of the following parameters consistent with the plugin you wish to develop:

**pluginFormat** = _A name with no whitespace that best describes the format_ (e.g. raw, yum, npm etc.)

**pluginClass** = _The class name that will be used to generate the plugin boilerplate code_ (e.g. Raw, Yum, Npm etc.)

#### Optional parameters:

**nexusPluginsVersion** = _The version of Nexus to use in the format to be developed_ 
(default: Declared as a property in the archetype [pom.xml ~line 62-> defaultNexusPluginsVersion](./pom.xml#L62]))

**artifactId** = _The artifactId of the format to be developed_ (default: nexus-repository-${pluginFormat})

**groupId** = _The groupId (and package) of the format to be developed_ (default: org.sonatype.nexus.repository)

**version** = _The version of the format to be developed_ (default: 0.0.1-SNAPSHOT)     

## How to contribute to this archetype

The standard [Maven Archetype Plugin](https://maven.apache.org/archetype/maven-archetype-plugin/index.html) 
docs are a good place to start.

We also use the [archetype integration-test goal](https://maven.apache.org/archetype/maven-archetype-plugin/integration-test-mojo.html)
to verify the archetype works as expected. You may need to update some of the [reference](src/test/resources/projects/it1/reference/)
files after changes are made that affect generated source code. 

You can manually run the integration tests via:

    mvn clean package archetype:integration-test
