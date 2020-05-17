package me.lucashagen.mcstats.bukkit;

import me.lucashagen.mcstats.api.APIType;
import me.lucashagen.mcstats.api.ServerAPI;
import org.bukkit.Bukkit;

import java.util.logging.Logger;

public class BukkitAPI implements ServerAPI {

    private BukkitMain plugin;

    public BukkitAPI(BukkitMain plugin) {
        this.plugin = plugin;
    }

    public Logger getLogger() {
        return Bukkit.getLogger();
    }

    public APIType getType() {
        return APIType.BUKKIT;
    }

}
