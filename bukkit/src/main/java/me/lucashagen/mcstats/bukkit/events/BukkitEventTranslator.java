package me.lucashagen.mcstats.bukkit.events;

import me.lucashagen.mcstats.MSEventListener;
import me.lucashagen.mcstats.bukkit.BukkitPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BukkitEventTranslator implements Listener {

    private MSEventListener msListener;

    public BukkitEventTranslator(MSEventListener msListener) {
        this.msListener = msListener;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event)
    {
        msListener.onPlayerLoginEvent(new BukkitPlayer(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        msListener.onPlayerDisconnectEvent(new BukkitPlayer(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event)
    {
        msListener.onPlayerDisconnectEvent(new BukkitPlayer(event.getPlayer()));
    }

}
