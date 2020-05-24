package me.lucashagen.mcstats.api;

import java.util.UUID;

public abstract class MSPlayer {

    /**
     * Gets the player's unique id
     *
     * @return Player's UUID
     */
    public abstract UUID getUUID();

    /**
     * Gets the player's username (not displayname)
     *
     * @return Player's Username
     */
    public abstract String getUsername();

    /**
     * Checks if player is online
     *
     * @return online
     */
    public abstract boolean isOnline();

    public abstract String getIPAddress();



}
