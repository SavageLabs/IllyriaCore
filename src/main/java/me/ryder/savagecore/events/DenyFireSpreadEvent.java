package me.ryder.savagecore.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;

import me.ryder.savagecore.persist.Config;

public class DenyFireSpreadEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void disableFireSpread(BlockIgniteEvent e) {
        if (Config.fireSpreadToggle && e.getCause() == IgniteCause.SPREAD) {
            e.setCancelled(true);
        }
    }
}