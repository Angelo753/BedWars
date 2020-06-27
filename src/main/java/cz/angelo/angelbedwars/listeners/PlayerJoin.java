package cz.angelo.angelbedwars.listeners;

import cz.angelo.angelbedwars.configurations.Arenas;
import cz.angelo.angelbedwars.configurations.Config;
import cz.angelo.angelbedwars.configurations.Messages;
import cz.angelo.angelbedwars.utils.Colors;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.UnsupportedEncodingException;

public class PlayerJoin implements Listener {

    /*private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;
    private World w;
     */

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) throws UnsupportedEncodingException {
        Player p = e.getPlayer();
        e.setJoinMessage(Colors.colored(Messages.get().getString("join").replace("%player%", p.getName()).replace("%online%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%max%", String.valueOf(Config.get().getInt("maxPlayers")))));
        if (Arenas.get().getString("arena").isEmpty() || Arenas.get().getString("lobby").isEmpty()){
            Bukkit.broadcastMessage("§8(AngelBedWars§8) §7Lokace ještě nebyly nastaveny.");
        }else {
            double x = Arenas.get().getDouble("lobby.x");
            double y = Arenas.get().getDouble("lobby.y");
            double z = Arenas.get().getDouble("lobby.z");
            float yaw = Arenas.get().getInt("lobby.yaw");
            float pitch = Arenas.get().getInt("lobby.pitch");
            World w = Bukkit.getWorld(Arenas.get().getString("lobby.world"));
            if (!Bukkit.getWorlds().contains(w)){
                Bukkit.broadcastMessage("§8(AngelBedWars§8) §7Chyba, svět §6§o" + w + " §7neexistuje.");
            }else {
                p.teleport(new Location(w, x, y, z, yaw, pitch));
            }
        }
    }

    @EventHandler
    public void preLogin(AsyncPlayerPreLoginEvent e) throws UnsupportedEncodingException {
        if (Config.get().getInt("maxPlayers") <= Bukkit.getOnlinePlayers().size()){
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, Messages.get().getString("maxPlayersKick"));
        }
    }

}
