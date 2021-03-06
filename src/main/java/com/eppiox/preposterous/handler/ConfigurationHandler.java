package com.eppiox.preposterous.handler;

import com.eppiox.preposterous.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

/**
 * Created by Epi on 19/02/2015.
 */
public class ConfigurationHandler {
    public static Configuration configuration;
    public static boolean testValue = false;

    public static void init(File configFile)
    {
    // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }
    private static void loadConfiguration()
    {
        testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an example configuration value");
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

}
