package me.ryder.savagecore.events;

import me.ryder.savagecore.persist.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;

public class DenyFireSpreadEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void disableFireSpread(BlockIgniteEvent e) {
        BlockIgniteEvent.IgniteCause cause = e.getCause();
        // Block block = e.getBlock();
        // World world = block.getWorld();
        boolean isFireSpread = (cause == BlockIgniteEvent.IgniteCause.SPREAD);

        if (Config.fireSpreadToggle && isFireSpread) {
            e.setCancelled(true);
        }
    }
}
