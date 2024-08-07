package com.github.kaspiandev.instadeepslate;

import org.bukkit.plugin.java.JavaPlugin;

public final class InstaDeepslate extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeepslateMineListener(), this);
    }

}
