package me.ryder.savagecore.events;

import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import me.ryder.savagecore.persist.Config;

public class DenyEndermanEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEntityChangeBlock(EntityChangeBlockEvent e) {
        Entity ent = e.getEntity();
        if (ent instanceof Enderman) {
            if (Config.enderManGriefToggle) {
                e.setCancelled(true);
            }
        }
    }
}