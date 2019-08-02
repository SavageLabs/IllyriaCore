package me.ryder.savagecore.events;

import me.ryder.savagecore.persist.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class DenyWaterRedstone implements Listener {

    @EventHandler
    public void onNoWater(BlockFromToEvent e) {
        String block = e.getToBlock().getType().toString();

        if (Config.noWaterItemsToggle) {
            if (Config.itemTypes.contains(block)) {
                e.setCancelled(true);
            }
        }
    }
}
