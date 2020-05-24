package me.lucashagen.mcstats.bungee;

import me.lucashagen.mcstats.Main;
import me.lucashagen.mcstats.utils.Lang;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;

public class BungeeMain extends Plugin {

    private BungeeAPI api = null;
    private Main main = null;

    @Override
    public void onLoad() {
        this.api = BungeeAPI.createInstance(this);
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

    public Configuration loadConfiguration() throws IOException {

        File configFile = new File(getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            if (!getDataFolder().exists()) {
                if (!getDataFolder().mkdir()) {
                    throw new IOException("Unable to create plugin folder!");
                }
            }

            api.log(Level.INFO, Lang.CREATING_CONFIG.getMessage());
            Files.copy(this.getResourceAsStream("config.yml"),
                    configFile.toPath());
        }

        return ConfigurationProvider.getProvider(YamlConfiguration.class)
                .load(configFile);
    }
}
