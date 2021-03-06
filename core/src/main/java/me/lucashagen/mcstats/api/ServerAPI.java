package me.lucashagen.mcstats.api;

import me.lucashagen.mcstats.MSEventListener;
import me.lucashagen.mcstats.utils.Lang;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract class that handles the communication between the 'core' module and
 * the Craftbukkit/Bungeecord server APIs.
 */
public abstract class ServerAPI {

    /**
     * Gets the plugin logger
     *
     * @return Console Logger
     */
    protected abstract Logger getLogger();

    /**
     * Gets the API Type (BUKKIT or BUNGEE)
     *
     * @return API Type
     */
    public abstract APIType getType();

    /**
     * Gets the plugin's configuration
     *
     * If the configuration file is not yet loaded, this function will load it.
     * If the configuration file does not exist, this function will copy the
     * default configuration file.
     *
     * @return PluginConfiguration
     */
    public abstract PluginConfiguration getConfig();

    /**
     * Logs a message to the plugin logger
     *
     * @param severe Severity Level
     * @param message Message
     */
    public void log(Level severe, String message)
    {
        getLogger().log(severe, Lang.LOG_TAG.getMessage() + " " + message);
    }

    /**
     * Gets a online player.
     * If the player is not online, null is returned.
     *
     * @param uuid Player's UUID, not null
     * @return MSPlayer, or null if player is offline
     */
    public abstract MSPlayer getPlayer(UUID uuid);

    /**
     * Registers the event listener
     *
     * @param listener Event listener
     */
    public abstract void registerEventListener(MSEventListener listener);

    /**
     * Connected Player count
     *
     * @return Online player count
     */
    public abstract int getOnlinePlayerCount();
}
