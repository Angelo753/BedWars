package cz.angelo.angelbedwars.commands;

import cz.angelo.angelbedwars.configurations.Arenas;
import cz.angelo.angelbedwars.configurations.Config;
import cz.angelo.angelbedwars.configurations.Messages;
import cz.angelo.angelbedwars.utils.Colors;
import cz.angelo.angelbedwars.utils.HashMaps;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class AngelBedWars implements CommandExecutor {

    //cmd(args0) args1 args2 args3

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 0){
            }else {
                if (args.length == 1){
                    if (args[0].equalsIgnoreCase("help")){
                        List<String> help = null;
                        try {
                            help = Messages.get().getStringList("help");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < help.size(); i++){
                            p.sendMessage(Colors.colored(help.get(i)).replace("%command%", command.getName()));
                        }
                    }
                    if (p.hasPermission("angelbedwars.command.setregion") || p.hasPermission("angelbedwars.bypass")) {
                        if (args[0].equalsIgnoreCase("setregion")) {
                            if (!HashMaps.setRegion.containsKey(p.getName())){
                                HashMaps.setRegion.put(p.getName(), 1);
                                return true;
                            }else {
                                PlayerInventory inv = p.getInventory();
                                Material material = Material.valueOf(Config.get().getString("regionTools.material"));
                                ItemStack item = new ItemStack(material);
                                ItemMeta meta = item.getItemMeta();
                                meta.setDisplayName(Colors.colored("regionTools.name"));
                                item.setItemMeta(meta);
                                inv.addItem(item);
                            }
                        }
                    }else {
                        try {
                            Messages.get().getString("permissionError");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }else {
                    if (args.length == 2){
                        if (args[0].equalsIgnoreCase("create")){
                            if (args[1] != null){
                                Arenas.get().set("arena." + args[0], args[1]);
                            }else {
                                try {
                                    p.sendMessage(Colors.colored(Messages.get().getString("wrongUsage")));
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }else {

                    }
                }
            }
        }else {
            sender.sendMessage("§8(AngelBedWars§8) §7Musíš být hráč, aby byl použit tento příkaz.");
        }

        return false;
    }

}
