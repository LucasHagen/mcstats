package me.lucashagen.mcstats.bungee;

import me.lucashagen.mcstats.MSEventListener;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class BungeeEventTranslator implements Listener {

    private MSEventListener msListener;

    public BungeeEventTranslator(MSEventListener msListener) {
        this.msListener = msListener;
    }

    @EventHandler
    public void onPlayerLogin(PostLoginEvent event)
    {
        msListener.onPlayerLoginEvent(new BungeePlayer(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerDisconnectEvent event)
    {
        msListener.onPlayerDisconnectEvent(new BungeePlayer(event.getPlayer()));
    }

}
