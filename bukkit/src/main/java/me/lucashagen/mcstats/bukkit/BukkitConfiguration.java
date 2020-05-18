package me.lucashagen.mcstats.bukkit;

import me.lucashagen.mcstats.api.PluginConfiguration;
import org.bukkit.configuration.file.FileConfiguration;

public class BukkitConfiguration implements PluginConfiguration {

    private final FileConfiguration bukkitConfig;

    public BukkitConfiguration(FileConfiguration bukkitConfig) {
        this.bukkitConfig = bukkitConfig;
    }

    @Override
    public Object get(String key) {
        return this.bukkitConfig.get(key);
    }

    @Override
    public String getString(String key) {
        return this.bukkitConfig.getString(key);
    }

    @Override
    public boolean getBoolean(String key) {
        return this.bukkitConfig.getBoolean(key);
    }

    @Override
    public int getInt(String key) {
        return this.bukkitConfig.getInt(key);
    }
}
