package me.lucashagen;

import me.lucashagen.player.SessionManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    SessionManager sessionManager;

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
