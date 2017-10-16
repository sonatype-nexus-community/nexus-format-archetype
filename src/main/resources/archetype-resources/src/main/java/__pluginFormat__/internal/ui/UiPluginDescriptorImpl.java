package ${package}.${pluginFormat}.internal.ui;

import javax.annotation.Priority;
import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.rapture.UiPluginDescriptorSupport;

@Named
@Singleton
@Priority(Integer.MAX_VALUE - 200)
public class UiPluginDescriptorImpl
    extends UiPluginDescriptorSupport
{
  public UiPluginDescriptorImpl() {
    super(${artifactId});
    setNamespace("NX.${pluginFormat}");
    setConfigClassName("NX.${pluginFormat}.app.PluginConfig");
  }
}
