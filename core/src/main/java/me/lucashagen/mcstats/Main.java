package me.lucashagen.mcstats;

import me.lucashagen.mcstats.player.SessionManager;
import me.lucashagen.mcstats.utils.Lang;
import me.lucashagen.mcstats.api.ServerAPI;
import me.lucashagen.mcstats.database.MySQLDatabase;
import me.lucashagen.mcstats.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;

public class Main {

    private static ServerAPI api;

    private MySQLDatabase database;

    private MSEventListener listener;

    private boolean isDisabled = false;

    /**
     * Constructor
     *
     * @param serverAPI Server API
     */
    public Main(ServerAPI serverAPI) {
        api = serverAPI;
    }

    /**
     * This method is called on the onLoad from Craftbukkit and Bungeecord
     */
    public void onLoad() {

    }

    /**
     * This method is called on the onEnable from Craftbukkit and Bungeecord
     */
    public void onEnable() {
        try {
            copyJarLibraries();
            initializeDatabase();

            listener = new MSEventListener(new SessionManager());
            api.registerEventListener(listener);

            api.log(Level.INFO, String.format("Plugin Enabled (%s version)",
                    api.getType().toString()));
        } catch (Exception e) {
            e.printStackTrace();
            disablePlugin();
        }
    }

    /**
     * This method is called on the onEnable from Craftbukkit and Bungeecord
     */
    public void onDisable() {
        if (isDisabled) {
            return;
        }

        api.log(Level.INFO, String.format("Plugin Disabled (%s version)",
                api.getType().toString()));
    }

    /**
     * Initializes the database using the config.yml
     *
     * @throws IOException Database IOException
     */
    private void initializeDatabase() throws IOException {
        String database_type = api.getConfig().getString("database.use");

        String host = api.getConfig().getString("database.mysql.host");
        String db_name = api.getConfig().getString("database.mysql.database");
        String username = api.getConfig().getString("database.mysql.username");
        String password = api.getConfig().getString("database.mysql.password");

        database = new MySQLDatabase(host, db_name, username, password);

        database.initialize();
    }

    /**
     * This method should be called to force the plugin to be disabled
     */
    private void disablePlugin() {
        this.isDisabled = true;
        this.database = null;

        for (int i = 0; i < 5; i++) {
            getAPI().log(Level.SEVERE, Lang.PLUGIN_FORCED_DISABLE.getMessage());
        }
    }

    /**
     * Copies the necessary libraries to the folder '/plugins/libs/'
     */
    public void copyJarLibraries() throws IOException, URISyntaxException {
        File folder = new File("plugins/lib");
        if (!folder.exists()) {
            folder.mkdir();
        }

        FileUtils.copyFromJar("/lib", folder.toPath());
    }

    /**
     * Gets the API to communicate with the Server API (Craftbukkit or
     * Bungeecord)
     *
     * @return ServerAPI
     */
    public static ServerAPI getAPI() {
        return api;
    }
}
