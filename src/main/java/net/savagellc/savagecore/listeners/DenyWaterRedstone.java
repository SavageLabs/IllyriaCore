package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Conf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class DenyWaterRedstone implements Listener {

    @EventHandler
    public void onNoWater(BlockFromToEvent e) {
        if (Conf.denyWaterItemBreak) {
            String block = e.getToBlock().getType().toString();
            if (Conf.itemWaterDeny.contains(block)) {
                e.setCancelled(true);
            }
        }
    }
}