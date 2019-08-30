package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Conf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;

public class DenyFireSpreadEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void disableFireSpread(BlockIgniteEvent e) {
        if (Conf.fireSpreadToggle && e.getCause() == IgniteCause.SPREAD) {
            e.setCancelled(true);
        }
    }
}