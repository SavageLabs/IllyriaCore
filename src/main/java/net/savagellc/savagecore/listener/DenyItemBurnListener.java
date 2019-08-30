package net.savagellc.savagecore.listener;

import net.savagellc.savagecore.persist.Conf;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DenyItemBurnListener implements Listener {

    @EventHandler
    public void onItemBurn(EntityDamageEvent e) {
        if (Conf.itemBurnToggle) {
            Entity en = e.getEntity();
            DamageCause cause = e.getCause();
            if (en.getType() != EntityType.DROPPED_ITEM) {
                return;
            }
            if (!Conf.damageTypes.contains(cause.toString())) {
                return;
            } else {
                e.setCancelled(true);
                e.setDamage(0.0D);
            }
        }
    }
}