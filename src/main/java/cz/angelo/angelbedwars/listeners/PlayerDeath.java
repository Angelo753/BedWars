package cz.angelo.angelbedwars.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void playerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        p.spigot().respawn();
    }

}
