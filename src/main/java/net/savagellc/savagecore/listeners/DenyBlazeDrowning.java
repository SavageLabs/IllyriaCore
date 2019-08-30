package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Conf;
import org.bukkit.entity.Blaze;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.*;

public class DenyBlazeDrowning implements Listener {

    @EventHandler
    public void onBlazeDrown(EntityDamageEvent e) {
        if (Conf.denyBlazeDrowning) {
            if (e.isCancelled()) { return; }
            if (e.getEntity() instanceof Blaze && e.getCause() == DamageCause.DROWNING) {
                e.setCancelled(true);
            }
        }
    }
}