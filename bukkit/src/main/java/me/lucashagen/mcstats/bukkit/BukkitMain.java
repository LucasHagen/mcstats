package me.lucashagen.mcstats.bukkit;

import me.lucashagen.mcstats.Main;
import me.lucashagen.mcstats.utils.Lang;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class BukkitMain extends JavaPlugin {

    private Main main = null;
    private BukkitAPI api = null;

    @Override
    public void onLoad() {
        this.api = new BukkitAPI(this);
        this.main = new Main(api);

        this.main.onLoad();
    }

    @Override
    public void onEnable() {
        this.main.onEnable();
    }

    @Override
    public void onDisable() {
        this.main.onDisable();
    }

    /**
     * Loads the config file located in ./plugins/mcstats/config.yml
     * If the config doesn't exist, the default config.yml is created.
     */
    public FileConfiguration loadConfiguration() {
        FileConfiguration config = null;
        File configFile = new File("./plugins/mcstats/config.yml");

        if (!configFile.exists()) {
            api.log(Level.INFO, Lang.CREATING_CONFIG.getMessage());
            saveResource("config.yml", false);
        }

        config = YamlConfiguration.loadConfiguration(configFile);

        return config;
    }

}