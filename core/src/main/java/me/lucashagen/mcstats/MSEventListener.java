package me.lucashagen.mcstats;

import me.lucashagen.mcstats.api.MSPlayer;
import me.lucashagen.mcstats.player.SessionManager;

import java.util.logging.Level;

public class MSEventListener {

    private SessionManager sessionManager;

    public MSEventListener(SessionManager sessionManager)
    {
        this.sessionManager = sessionManager;
    }

    /**
     * Called when a player joins the server
     *
     * @param player Player
     */
    public void onPlayerLoginEvent(MSPlayer player)
    {
        Main.getAPI().log(Level.INFO,
                String.format("Player '%s' joined the server!",
                        player.getUsername()));
    }

    /**
     * Called when a player leaves the server
     *
     * For bukkit version, PlayerKickEvent should also trigger this event.
     *
     * @param player Player
     */
    public void onPlayerDisconnectEvent(MSPlayer player)
    {
        Main.getAPI().log(Level.INFO,
                String.format("Player '%s' left the server!",
                        player.getUsername()));
    }

}
