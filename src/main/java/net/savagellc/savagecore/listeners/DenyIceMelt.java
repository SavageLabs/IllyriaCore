package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Config;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import net.prosavage.baseplugin.XMaterial;

public class DenyIceMelt implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void iceMelt(BlockFadeEvent e) {
        Block block = e.getBlock();
        Material ice = XMaterial.ICE.parseMaterial();
        Material pice = XMaterial.PACKED_ICE.parseMaterial();
        if (Config.denyIceMelt) {
            if (block.getType() == ice || block.getType() == pice) {
                e.setCancelled(true);
            }
        }
    }
}