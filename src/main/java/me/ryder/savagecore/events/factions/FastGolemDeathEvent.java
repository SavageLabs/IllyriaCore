package me.ryder.savagecore.events.factions;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import me.ryder.savagecore.persist.Config;

public class FastGolemDeathEvent implements Listener {

    @EventHandler
    public void onIGLava(EntityDamageEvent e) {
        if (Config.fastIronGolemDeath) {
                if (isIG(e.getEntity()) && isFire(e.getCause())) {
                    e.setDamage(10000.0D);
                }
        }
    }

    private boolean isIG(Entity e) {
        return e.getType() == EntityType.IRON_GOLEM;
    }

    private boolean isFire(DamageCause dc) {
        return dc == DamageCause.FIRE || dc == DamageCause.FIRE_TICK || dc == DamageCause.LAVA;
    }
}