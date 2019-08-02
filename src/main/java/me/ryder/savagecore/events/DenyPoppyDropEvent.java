package me.ryder.savagecore.events;

import me.ryder.savagecore.persist.Config;
import net.prosavage.baseplugin.XMaterial;
import org.bukkit.entity.IronGolem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DenyPoppyDropEvent implements Listener {

    @EventHandler
    public void onIronGolemDrop(EntityDeathEvent e) {
        if (Config.noPoppyDropToggle) {
            if (!(e.getEntity() instanceof IronGolem)) {
                return;
            }
            for (ItemStack is : e.getDrops()) {
                if (is.getType().equals(XMaterial.POPPY.parseMaterial())) {
                    is.setType(XMaterial.AIR.parseMaterial());
                }
            }
        }
    }
}
