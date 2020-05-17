package me.lucashagen.mcstats.bukkit;

import me.lucashagen.mcstats.Main;
import org.bukkit.plugin.java.JavaPlugin;

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

}