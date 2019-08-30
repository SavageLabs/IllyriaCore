package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Config;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DenyItemBurn implements Listener {

    @EventHandler
    public void onItemBurn(EntityDamageEvent e) {
        if (Config.denyItemBurn) {
            Entity en = e.getEntity();
            DamageCause cause = e.getCause();
            if (en.getType() != EntityType.DROPPED_ITEM) {
                return;
            }
            if (!Config.itemBurnTypes.contains(cause.toString())) {
                return;
            } else {
                e.setCancelled(true);
                e.setDamage(0.0D);
            }
        }
    }
}