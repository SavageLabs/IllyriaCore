package me.ryder.savagecore.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

import me.ryder.savagecore.persist.Config;

public class DenyWaterRedstone implements Listener {

    @EventHandler
    public void onNoWater(BlockFromToEvent e) {
        if (Config.noWaterItemsToggle) {
            String block = e.getToBlock().getType().toString();
            if (Config.itemTypes.contains(block)) {
                e.setCancelled(true);
            }
        }
    }
}