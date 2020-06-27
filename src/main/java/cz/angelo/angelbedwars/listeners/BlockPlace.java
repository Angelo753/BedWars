package cz.angelo.angelbedwars.listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class BlockPlace implements Listener {

    @EventHandler
    public void blockPlace(BlockPlaceEvent e){
        Block b = e.getBlock();
        b.setMetadata("PLACED", new FixedMetadataValue(cz.angelo.angelbedwars.Main.getInstance, "placedbyplayer"));
    }

}
