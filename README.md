# nexus-format-archetype
Archetype for creating Nexus format plugin with a _lot_ of the boilerplate required to start development already created.

## How to create a format
Once the code has been checked out.

Build the archetype:

    mvn clean install

Change directory to a new folder where you wish to generate the format boilerplate code.
 
Generating a format plugin is as easy as running the following:
     
    mvn archetype:generate                              \ 
      -DarchetypeArtifactId=nexus-format-archetype      \
      -DarchetypeGroupId=org.sonatype.nexus.archetype   \
      -DarchetypeVersion=1.0-SNAPSHOT                   \
      -DgroupId=org.sonatype.nexus.repository           \
      -DartifactId=nexus-repository-foo                 \
      -DpluginFormat=foo                                \
      -DpluginClass=Foo                                 \
      -Dversion=0.0.1

It is recommended to keep the naming of the following parameters consistent with the plugin you wish to develop:

**pluginFormat** = _A name with no whitespace that best describes the format_ (e.g. raw, yum, npm etc.)

**pluginClass** = _The class name that will be used to generate the plugin boilerplate code_ (e.g. Raw, Yum, Npm etc.)

**version** = _The version of the format to be developed_      
