package net.savagellc.savagecore.listeners.pvp;

import net.savagellc.savagecore.persist.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class NoHitDelay implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (Config.noHitDelaySettings.toggle) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setMaximumNoDamageTicks(Config.noHitDelaySettings.delay);
            }
        }
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (Config.noHitDelaySettings.toggle) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setMaximumNoDamageTicks(Config.noHitDelaySettings.delay);
            }
        }
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        if (Config.noHitDelaySettings.toggle) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setMaximumNoDamageTicks(Config.noHitDelaySettings.delay);
            }
        }
    }
    @EventHandler
    public void onTeleportEvent(PlayerTeleportEvent e) {
        if (Config.noHitDelaySettings.toggle) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setMaximumNoDamageTicks(Config.noHitDelaySettings.delay);
            }
        }
    }
}