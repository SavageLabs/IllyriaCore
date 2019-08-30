package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Config;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class DenyMobItemPickUp implements Listener {

    @EventHandler
    public void onEntityPickUp(EntityPickupItemEvent e) {
        if (Config.denyMobItemPickup) {
            if (isZombie(e.getEntity())) {
                e.setCancelled(true);
            }
        }
    }
    private boolean isZombie(Entity e) { return e.getType() == EntityType.ZOMBIE; }
}