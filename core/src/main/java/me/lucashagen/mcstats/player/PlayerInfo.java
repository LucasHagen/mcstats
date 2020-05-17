package me.lucashagen.mcstats.player;

import java.util.UUID;

public class PlayerInfo {

    private UUID uuid;
    private String username;
    private Session session;

    public PlayerInfo(UUID uuid, String username)
    {
        this.uuid = uuid;
        this.username = username;
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
