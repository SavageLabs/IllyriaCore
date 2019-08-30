package net.savagellc.savagecore.listener.mobs;

import net.savagellc.savagecore.persist.Conf;
import net.prosavage.baseplugin.XMaterial;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;

public class FastIronGolemDeath implements Listener {
    @EventHandler
    public void onIGDeath(EntityDamageEvent e) {
        if (Conf.fastIronGolemDeathSettings.toggle) {
            if (isIG(e.getEntity()) && isF(e.getCause())) {
                e.setDamage(Conf.fastIronGolemDeathSettings.damage);
            }
        }
    }
    @EventHandler
    public void onIGDeath2(EntityDeathEvent e) {
        if (Conf.noPoppyDropToggle) {
            if (isIG(e.getEntity())) {
                Material poppy = XMaterial.POPPY.parseMaterial();
                e.getDrops().removeIf(itemStack -> itemStack.getType() == poppy);
            }
        }
    }

    private boolean isIG(Entity e) {
        return e.getType() == EntityType.IRON_GOLEM;
    }
    private boolean isF(DamageCause dc) {
        return dc == DamageCause.FIRE || dc == DamageCause.FIRE_TICK || dc == DamageCause.LAVA;
    }
}