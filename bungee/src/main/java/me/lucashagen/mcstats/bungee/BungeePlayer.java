package me.lucashagen.mcstats.bungee;

import me.lucashagen.mcstats.api.MSPlayer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.UUID;

public class BungeePlayer extends MSPlayer {

    private ProxiedPlayer proxiedPlayer;

    protected BungeePlayer(ProxiedPlayer proxiedPlayer)
    {
        this.proxiedPlayer = proxiedPlayer;
    }

    @Override
    public UUID getUUID() {
        return proxiedPlayer.getUniqueId();
    }

    @Override
    public String getUsername() {
        return proxiedPlayer.getName();
    }

    @Override
    public boolean isOnline() {
        return proxiedPlayer.isConnected();
    }

    @Override
    public String getIPAddress() {
        return proxiedPlayer.getSocketAddress().toString();
    }
}
