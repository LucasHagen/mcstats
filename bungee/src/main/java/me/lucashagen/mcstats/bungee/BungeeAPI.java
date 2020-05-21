package me.lucashagen.mcstats.bungee;

import me.lucashagen.mcstats.api.APIType;
import me.lucashagen.mcstats.api.Lang;
import me.lucashagen.mcstats.api.PluginConfiguration;
import me.lucashagen.mcstats.api.ServerAPI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BungeeAPI extends ServerAPI {

    private final BungeeMain plugin;

    private BungeeConfiguration bungeeConfiguration;

    public BungeeAPI(BungeeMain plugin)
    {
        this.plugin = plugin;
    }

    @Override
    protected Logger getLogger() {
        return plugin.getProxy().getLogger();
    }

    @Override
    public APIType getType() {
        return APIType.BUNGEE;
    }

    @Override
    public PluginConfiguration getConfig() {
        if(bungeeConfiguration == null)
        {
            try {
                bungeeConfiguration =
                        new BungeeConfiguration(plugin.loadConfiguration());
            } catch (IOException e) {
                e.printStackTrace();
                log(Level.SEVERE, Lang.CONFIG_ERROR.getMessage());
                log(Level.SEVERE, e.toString());
            }
        }

        return bungeeConfiguration;
    }

}
