package cz.angelo.angelbedwars;

import cz.angelo.angelbedwars.listeners.BlockBreak;
import cz.angelo.angelbedwars.listeners.BlockPlace;
import cz.angelo.angelbedwars.listeners.PlayerQuit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static cz.angelo.angelbedwars.Main getInstance;

    @Override
    public void onEnable(){
        getInstance = this;
        configCreator();
        eventRegister();
        this.getCommand("angelbedwars").setExecutor(new cz.angelo.angelbedwars.commands.AngelBedWars());
    }

    @Override
    public void onDisable(){

    }

    public void eventRegister(){
        this.getServer().getPluginManager().registerEvents(new cz.angelo.angelbedwars.listeners.PlayerDeath(), this);
        this.getServer().getPluginManager().registerEvents(new cz.angelo.angelbedwars.listeners.PlayerJoin(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
        this.getServer().getPluginManager().registerEvents(new BlockPlace(), this);
        this.getServer().getPluginManager().registerEvents(new BlockBreak(), this);
    }

    public void configCreator(){
        this.saveResource("config.yml", false);
        this.saveResource("messages.yml", false);
        this.saveResource("arenas.yml", false);
    }

}
