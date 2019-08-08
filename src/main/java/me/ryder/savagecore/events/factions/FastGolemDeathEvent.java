package me.ryder.savagecore.events.factions;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;
import me.ryder.savagecore.persist.Config;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class FastGolemDeathEvent implements Listener {

    @EventHandler
    public void onIGLava(EntityDamageEvent e) {
        FLocation loc = new FLocation();

        Faction faction = Board.getInstance().getFactionAt(loc);

        if (Config.fastIronGolemDeath) {
            if (faction.isNormal()) {
                if (IG(e.getEntity()) && Fire(e.getCause())) {
                    e.setDamage(10000.0D);
                }
            }
        }
    }

    private boolean IG(Entity e) {
        return e.getType() == EntityType.IRON_GOLEM;
    }

    private boolean Fire(DamageCause dc) {
        return (dc.equals(DamageCause.FIRE) || dc.equals(DamageCause.LAVA) || dc.equals(DamageCause.FIRE_TICK));
    }
}
