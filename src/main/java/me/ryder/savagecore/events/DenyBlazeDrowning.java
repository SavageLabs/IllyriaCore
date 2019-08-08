package me.ryder.savagecore.events;

import org.bukkit.entity.Blaze;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.*;

import me.ryder.savagecore.persist.Config;

public class DenyBlazeDrowning implements Listener {

    @EventHandler
    public void onBlazeDrown(EntityDamageEvent e) {
        if (Config.antiBlazeDrownToggle) {
            if (e.isCancelled()) {
                return;
            }
            if (e.getEntity() instanceof Blaze && e.getCause() == DamageCause.DROWNING) {
                e.setCancelled(true);
            }
        }
    }
}