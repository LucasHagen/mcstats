package me.lucashagen.mcstats.api;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ServerAPI {

    public abstract Logger getLogger();

    public abstract APIType getType();

    public void log(Level severe, String message)
    {
        getLogger().log(severe, message);
    }
}
