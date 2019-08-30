package net.savagellc.savagecore.listeners.pvp;

import net.savagellc.savagecore.persist.Conf;
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
        if (Conf.noHitDelaySettings.toggle) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setMaximumNoDamageTicks(Conf.noHitDelaySettings.delay);
            }
        }
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (Conf.noHitDelaySettings.toggle) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setMaximumNoDamageTicks(Conf.noHitDelaySettings.delay);
            }
        }
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        if (Conf.noHitDelaySettings.toggle) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setMaximumNoDamageTicks(Conf.noHitDelaySettings.delay);
            }
        }
    }
    @EventHandler
    public void onTeleportEvent(PlayerTeleportEvent e) {
        if (Conf.noHitDelaySettings.toggle) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setMaximumNoDamageTicks(Conf.noHitDelaySettings.delay);
            }
        }
    }
}