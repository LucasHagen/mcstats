package me.lucashagen.mcstats.bungee;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

public class BungeeMain extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getLogger().log(Level.INFO, "PLUGIN ENABLEEEEEEEED ---------------------------------------------");
    }
}
