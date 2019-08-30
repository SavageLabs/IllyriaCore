package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Config;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class DenyBabyMob implements Listener {

    @EventHandler
    public void onZombieSpawn(CreatureSpawnEvent e) {
        if (Config.denyBabyMobs && e.getEntity() instanceof Zombie) {
            Zombie z = (Zombie) e.getEntity();
            if (z.isBaby() && z.isInsideVehicle()) {
                e.setCancelled(true);
            }
        }
    }
}