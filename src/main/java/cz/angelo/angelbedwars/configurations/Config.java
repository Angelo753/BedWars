package cz.angelo.angelbedwars.configurations;

import cz.angelo.angelbedwars.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

public class Config {

    private static FileConfiguration config = null;
    private static File file = null;


    public static void reload() {
        if (config == null){
            file = new File(Main.getInstance.getDataFolder(), "config.yml");
        }
        config = YamlConfiguration.loadConfiguration(file);
        Reader defConfgiStream = new InputStreamReader(Main.getInstance.getResource("config.yml"), StandardCharsets.UTF_8);
        if (defConfgiStream != null){
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfgiStream);
            config.setDefaults(defConfig);
        }
    }

    public static FileConfiguration get() {
        if (config == null){
            reload();
        }
        return config;
    }

    public static void save(){
        if (config == null || file == null){
            return;
        }
        try {
            get().save(file);
        }catch (IOException e){
            Main.getInstance.getLogger().log(Level.SEVERE, "Could not save config to " + file, e);
        }
    }

}
