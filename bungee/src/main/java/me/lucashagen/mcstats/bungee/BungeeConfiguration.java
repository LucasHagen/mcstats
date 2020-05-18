package me.lucashagen.mcstats.bungee;

import me.lucashagen.mcstats.api.PluginConfiguration;
import net.md_5.bungee.config.Configuration;

public class BungeeConfiguration implements PluginConfiguration {

    private final Configuration bungeeConfig;

    public BungeeConfiguration(Configuration bungeeConfig)
    {
        this.bungeeConfig = bungeeConfig;
    }

    @Override
    public Object get(String key) {
        return this.bungeeConfig.get(key);
    }

    @Override
    public String getString(String key) {
        return this.bungeeConfig.getString(key);
    }

    @Override
    public boolean getBoolean(String key) {
        return this.bungeeConfig.getBoolean(key);
    }

    @Override
    public int getInt(String key) {
        return this.bungeeConfig.getInt(key);
    }
}
