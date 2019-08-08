package me.ryder.savagecore.events;

import java.util.Iterator;

import org.bukkit.Material;
import org.bukkit.entity.IronGolem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

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

            for (Iterator<ItemStack> it = e.getDrops().iterator(); it.hasNext();) {
                ItemStack item = it.next();

                if (item.getType() == poppy) it.remove();
            }
        }
    }
}
