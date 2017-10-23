# format-plugin
Archetype for creating Nexus format plugin with a _lot_ of the boilerplate required to start development already created.

## How to create a format
Once the code has been checked out.

Build the archetype:

    mvn clean install

Change directory to a new folder were you wish to generate the format boilerplate code.
 
Generating a format plugin is as easy as running the following:
     
    mvn archetype:generate                              \ 
      -DarchetypeArtifactId=format-plugin               \
      -DarchetypeGroupId=org.sonatype.nexus.archetype   \
      -DarchetypeVersion=1.0-SNAPSHOT                   \
      -DgroupId=com.sonatype.repository                 \
      -DartifactId=nexus-repository-foo                 \
      -DpluginFormat=foo                                \
      -DpluginClass=Foo                                 \
      -Dversion=1.0-SNAPSHOT                            \

It is recommended to keep the naming of the following parameters consistent with the plugin you wish to develop:

**pluginFormat** = _A name with no whitespace that best describes the format_

**pluginClass** = _The class name that will be used to generate the plugin boilerplate code_

**version** = _The version of the format to be developed_      