package me.lucashagen.mcstats;

import me.lucashagen.mcstats.api.ServerAPI;

import java.util.logging.Level;

public class Main {

    private ServerAPI api;

    public Main(ServerAPI api)
    {
        this.api = api;
    }

    public void onLoad()
    {
        api.getLogger().log(Level.INFO, String.format("Plugin LOADED!!!! (%s version)",
                api.getType().toString()));
    }

    public void onEnable()
    {
        api.getLogger().log(Level.INFO, String.format("Plugin ENABLED!!!! (%s version)",
                api.getType().toString()));
    }

    public void onDisable()
    {
        api.getLogger().log(Level.INFO, String.format("Plugin DISABLED!!!! (%s version)",
                api.getType().toString()));
    }

    public ServerAPI getAPI()
    {
        return this.api;
    }

}
