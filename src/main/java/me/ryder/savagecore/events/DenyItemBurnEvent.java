package me.ryder.savagecore.events;

import me.ryder.savagecore.persist.Config;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DenyItemBurnEvent implements Listener {

    @EventHandler
    public void onItemBurn(EntityDamageEvent e) {
        Entity en = e.getEntity();
        DamageCause cause = e.getCause();
        if (Config.itemBurnToggle) {
            if (en.getType() != EntityType.DROPPED_ITEM) {
                return;
            }
            if (!Config.damageTypes.contains(cause.toString())) {
                return;
            } else {
                e.setCancelled(true);
                e.setDamage(0.0D);
            }
        }
    }
}