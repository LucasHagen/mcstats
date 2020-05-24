package me.lucashagen.mcstats.bungee;

import me.lucashagen.mcstats.MSEventListener;
import me.lucashagen.mcstats.api.APIType;
import me.lucashagen.mcstats.api.MSPlayer;
import me.lucashagen.mcstats.api.PluginConfiguration;
import me.lucashagen.mcstats.api.ServerAPI;
import me.lucashagen.mcstats.utils.Lang;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BungeeAPI extends ServerAPI {

    private static BungeeAPI instance;

    public static BungeeAPI createInstance(BungeeMain bungeeMain) {
        if (instance == null) {
            instance = new BungeeAPI(bungeeMain);
        }

        return instance;
    }

    public static BungeeAPI getInstance() {
        return instance;
    }

    private final BungeeMain plugin;

    private BungeeConfiguration bungeeConfiguration;

    private BungeeAPI(BungeeMain plugin) {
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
        if (bungeeConfiguration == null) {
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

    @Override
    public MSPlayer getPlayer(UUID uuid) {
        ProxiedPlayer proxiedPlayer = plugin.getProxy().getPlayer(uuid);

        return proxiedPlayer == null ? null : new BungeePlayer(proxiedPlayer);
    }

    @Override
    public void registerEventListener(MSEventListener listener) {
        BungeeEventTranslator translator = new BungeeEventTranslator(listener);

        plugin.getProxy().getPluginManager().registerListener(plugin, translator);
    }

    @Override
    public int getOnlinePlayerCount() {
        return plugin.getProxy().getOnlineCount();
    }

}
