package me.ryder.savagecore.events;

import org.bukkit.Material;
import org.bukkit.entity.IronGolem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.ryder.savagecore.persist.Config;
import net.prosavage.baseplugin.XMaterial;

public class DenyPoppyDropEvent implements Listener {

    @EventHandler
    public void onIronGolemDrop(EntityDeathEvent e) {
        if (Config.noPoppyDropToggle) {
            if (!(e.getEntity() instanceof IronGolem)) {
                return;
            }

            Material poppy = XMaterial.POPPY.parseMaterial();

            e.getDrops().removeIf(item -> item.getType() == poppy);
        }
    }
}