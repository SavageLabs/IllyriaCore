package net.savagellc.savagecore.listener.autorespawn;

import net.savagellc.savagecore.persist.Conf;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Objects;

public class AutoRespawnListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (Conf.respawnScreenToggle) {
                Location dl = e.getEntity().getLocation();
                Player p = e.getEntity();
                PreAutoRespawnListener pre = new PreAutoRespawnListener(p, dl);

                Bukkit.getPluginManager().callEvent(pre);

                if (pre.isCancelled()) {
                    return;
                }

                (new BukkitRunnable() {
                    @Override
                    public void run() {
                        p.spigot().respawn();
                        Location rl = e.getEntity().getLocation();
                        Bukkit.getPluginManager().callEvent(new TargetAutoRespawnListener(e.getEntity(), dl, rl));
                    }
                }).runTaskTimer((Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("SavageCore"))), 1L, 1L);
            }
        }
    }