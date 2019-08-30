package net.savagellc.savagecore.listeners.pvp;

import net.savagellc.savagecore.persist.Config;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class BloodSpray implements Listener {

    @EventHandler
    public void onPlayerHit(EntityDamageEvent e) {
        if (Config.bloodSprayToggle) {
            if (!(e.getEntity() instanceof Player)) {
                return;
            }
            Entity target = e.getEntity();
            Location loc = target.getLocation();

            target.getWorld().playEffect(loc, Effect.STEP_SOUND, 152);
        }
    }
}