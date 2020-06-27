package cz.angelo.angelbedwars.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler
    public void blockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if (b.getMetadata("PLACED") == null){
                e.setCancelled(true);
        }
    }

}
