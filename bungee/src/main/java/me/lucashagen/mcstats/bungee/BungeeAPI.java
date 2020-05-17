package me.lucashagen.mcstats.bungee;

import me.lucashagen.mcstats.api.APIType;
import me.lucashagen.mcstats.api.ServerAPI;

import java.util.logging.Logger;

public class BungeeAPI extends ServerAPI {

    private BungeeMain plugin;

    public BungeeAPI(BungeeMain plugin)
    {
        this.plugin = plugin;
    }

    public Logger getLogger() {
        return plugin.getProxy().getLogger();
    }

    public APIType getType() {
        return APIType.BUNGEE;
    }

}
