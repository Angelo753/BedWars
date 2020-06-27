package cz.angelo.angelbedwars.listeners;

import cz.angelo.angelbedwars.configurations.Messages;
import cz.angelo.angelbedwars.utils.Colors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.UnsupportedEncodingException;

public class PlayerQuit implements Listener {

    @EventHandler
    public void playerQuit(PlayerQuitEvent e) throws UnsupportedEncodingException {
        Player p = e.getPlayer();
        e.setQuitMessage(Colors.colored(Messages.get().getString("quit").replace("%player%", p.getName()).replace("%online%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%max%", String.valueOf(cz.angelo.angelbedwars.configurations.Config.get().getInt("maxPlayers")))));
    }

}
