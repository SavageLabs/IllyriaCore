package me.ryder.savagecore.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

import me.ryder.savagecore.persist.Config;
import net.prosavage.baseplugin.XMaterial;

public class DenyIceMeltEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void iceMelt(BlockFadeEvent e) {
        if (Config.iceMeltToggle) {
            if (e.getBlock().getType() == XMaterial.ICE.parseMaterial() || e.getBlock().getType() == XMaterial.PACKED_ICE.parseMaterial()) {
                e.setCancelled(true);
            }
        }
    }
}