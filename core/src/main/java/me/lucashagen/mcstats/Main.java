package me.lucashagen.mcstats;

import me.lucashagen.mcstats.api.ServerAPI;

import java.util.logging.Level;

public class Main {

    private static ServerAPI api;

    public Main(ServerAPI serverAPI) {
        api = serverAPI;
    }

    public void onLoad() {
        api.getLogger().log(Level.INFO, String.format("Plugin Loaded (%s version)",
                api.getType().toString()));
    }

    public void onEnable() {
        api.getLogger().log(Level.INFO, String.format("Plugin Enabled (%s version)",
                api.getType().toString()));
    }

    public void onDisable() {
        api.getLogger().log(Level.INFO, String.format("Plugin Disabled (%s version)",
                api.getType().toString()));
    }

    public static ServerAPI getAPI() {
        return api;
    }
}
