package me.lucashagen.mcstats.bungee;

import me.lucashagen.mcstats.Main;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin {

    private BungeeAPI api = null;
    private Main main = null;

    @Override
    public void onLoad() {
        this.api = new BungeeAPI(this);
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
