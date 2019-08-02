package me.ryder.savagecore.events;

import me.ryder.savagecore.persist.Config;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class DenyBabyMobEvent implements Listener {
    @EventHandler
    public void onZombieSpawn(CreatureSpawnEvent e) {
        if (Config.babyMobToggle) {
            if (e.getEntity() instanceof Zombie) {
                Zombie z = (Zombie) e.getEntity();
                if (z.isBaby() && z.isInsideVehicle()) {
                    e.setCancelled(true);
                }
                if (e.getEntity() instanceof PigZombie) {
                    PigZombie pz = (PigZombie) e.getEntity();
                    if (pz.isBaby() && pz.isInsideVehicle()) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}
