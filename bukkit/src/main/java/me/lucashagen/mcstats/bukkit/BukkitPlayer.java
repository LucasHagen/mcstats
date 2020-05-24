package me.lucashagen.mcstats.bukkit;

import me.lucashagen.mcstats.api.MSPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BukkitPlayer extends MSPlayer {

    private Player player;

    public BukkitPlayer(Player player)
    {
        this.player = player;
    }

    @Override
    public UUID getUUID() {
        return player.getUniqueId();
    }

    @Override
    public String getUsername() {
        return player.getName();
    }

    @Override
    public boolean isOnline() {
        return player.isOnline();
    }

    @Override
    public String getIPAddress() {
        return player.getAddress().getAddress().toString();
    }
}
