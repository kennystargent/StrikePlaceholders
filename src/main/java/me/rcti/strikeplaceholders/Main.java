package me.rcti.strikeplaceholders;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        new PlaceholderManager().register();
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }
}