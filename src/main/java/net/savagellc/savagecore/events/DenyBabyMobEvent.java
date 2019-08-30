package net.savagellc.savagecore.events;

import net.savagellc.savagecore.persist.Conf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class DenyBabyMobEvent implements Listener {
    @EventHandler
    public void onZombieSpawn(CreatureSpawnEvent e) {
        if (Conf.babyMobToggle && e.getEntity() instanceof Zombie) {
            Zombie z = (Zombie) e.getEntity();
            if (z.isBaby() && z.isInsideVehicle()) {
                e.setCancelled(true);
            }
        }
    }
}