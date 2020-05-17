package me.lucashagen.mcstats.player;

import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerInfo {

    private UUID uuid;
    private String username;
    private Session session;

    public PlayerInfo(Player player)
    {
        this.uuid = player.getUniqueId();
        this.username = player.getName();
        this.session = new Session();
    }

    public void endSession()
    {
        this.session.end();
    }

    public Session getSession()
    {
        return this.session;
    }

    public String getUsername() {
        return username;
    }
}
