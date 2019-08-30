package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import net.prosavage.baseplugin.XMaterial;

public class DenyIceMelt implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void iceMelt(BlockFadeEvent e) {
        if (Config.denyIceMelt) {
            if (e.getBlock().getType() == XMaterial.ICE.parseMaterial() || e.getBlock().getType() == XMaterial.PACKED_ICE.parseMaterial()) {
                e.setCancelled(true);
            }
        }
    }
}