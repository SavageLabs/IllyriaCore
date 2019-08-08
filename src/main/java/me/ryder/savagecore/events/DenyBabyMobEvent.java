package me.ryder.savagecore.events;

import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import me.ryder.savagecore.persist.Config;

public class DenyBabyMobEvent implements Listener {
    @EventHandler
    public void onZombieSpawn(CreatureSpawnEvent e) {
        if (Config.babyMobToggle && e.getEntity() instanceof Zombie) {
            Zombie z = (Zombie) e.getEntity();
            if (z.isBaby() && z.isInsideVehicle()) {
                e.setCancelled(true);
            }
        }
    }
}
