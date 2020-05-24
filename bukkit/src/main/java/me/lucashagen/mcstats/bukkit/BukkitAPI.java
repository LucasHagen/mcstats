package me.lucashagen.mcstats.bukkit;

import me.lucashagen.mcstats.MSEventListener;
import me.lucashagen.mcstats.api.APIType;
import me.lucashagen.mcstats.api.MSPlayer;
import me.lucashagen.mcstats.api.PluginConfiguration;
import me.lucashagen.mcstats.api.ServerAPI;
import me.lucashagen.mcstats.bukkit.events.BukkitEventTranslator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;
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

    @Override
    public MSPlayer getPlayer(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);

        return player == null ? null : new BukkitPlayer(player);
    }

    @Override
    public void registerEventListener(MSEventListener listener) {
        BukkitEventTranslator translator = new BukkitEventTranslator(listener);

        plugin.getServer().getPluginManager().registerEvents(translator, plugin);
    }

    @Override
    public int getOnlinePlayerCount() {
        return plugin.getServer().getOnlinePlayers().size();
    }

}
