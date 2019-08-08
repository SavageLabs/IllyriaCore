package me.ryder.savagecore.events.autorespawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Objects;

import me.ryder.savagecore.persist.Config;

public class AutoRespawnEvent implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {

        if (Config.respawnScreenToggle) {
                Location dl = e.getEntity().getLocation();
                Player p = e.getEntity();
                PreAutoRespawnEvent pre = new PreAutoRespawnEvent(p, dl);

                Bukkit.getPluginManager().callEvent(pre);

                if (pre.isCancelled()) {
                    return;
                }

                (new BukkitRunnable() {
                    @Override
                    public void run() {
                        p.spigot().respawn();
                        Location rl = e.getEntity().getLocation();
                        Bukkit.getPluginManager().callEvent(new TargetAutoRespawnEvent(e.getEntity(), dl, rl));
                    }
                }).runTaskTimer((Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("SavageCore"))), 1L, 1L);
            }
        }
    }