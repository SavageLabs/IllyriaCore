package net.savagellc.savagecore.listener.player;

import net.savagellc.savagecore.persist.Conf;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class BloodSprayListener implements Listener {

    @EventHandler
    public void onPlayerHit(EntityDamageEvent e) {
        if (Conf.bloodSprayToggle) {
            if (!(e.getEntity() instanceof Player)) {
                return;
            }
            Entity target = e.getEntity();
            Location loc = target.getLocation();

            target.getWorld().playEffect(loc, Effect.STEP_SOUND, 152);
        }
    }
}