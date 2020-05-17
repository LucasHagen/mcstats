package me.lucashagen.mcstats.bukkit;

import me.lucashagen.mcstats.MainListener;
import me.lucashagen.mcstats.player.SessionManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitMain extends JavaPlugin {

    public SessionManager sessionManager;

    MainListener listener = null;

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        this.sessionManager = new SessionManager();
        this.listener = new MainListener(this);
        getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onDisable() {
        this.sessionManager.endAllSessions();
    }
}
