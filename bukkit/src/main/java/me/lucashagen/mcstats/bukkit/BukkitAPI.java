package me.lucashagen.mcstats.bukkit;

import me.lucashagen.mcstats.api.APIType;
import me.lucashagen.mcstats.api.PluginConfiguration;
import me.lucashagen.mcstats.api.ServerAPI;
import org.bukkit.Bukkit;

import java.util.logging.Logger;

public class BukkitAPI extends ServerAPI {

    private final BukkitMain plugin;

    private BukkitConfiguration bukkitConfig;

    public BukkitAPI(BukkitMain plugin) {
        this.plugin = plugin;
    }

    @Override
    protected Logger getLogger() {
        return Bukkit.getLogger();
    }

    @Override
    public APIType getType() {
        return APIType.BUKKIT;
    }

    @Override
    public PluginConfiguration getConfig() {
        if (bukkitConfig == null) {
            bukkitConfig = new BukkitConfiguration(plugin.loadConfiguration());
        }

        return bukkitConfig;
    }

}
