package com.github.carthax08.simplevoterewards;

import org.bukkit.plugin.java.JavaPlugin;

public final class Simplevoterewards extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new VoteListener(this), this);
        getCommand("simplevoterewards").setExecutor(new MainCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
