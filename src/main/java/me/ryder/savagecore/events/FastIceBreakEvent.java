package me.ryder.savagecore.events;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.listeners.FactionsPlayerListener;
import me.ryder.savagecore.persist.Config;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class FastIceBreakEvent implements Listener {

    @EventHandler
    public void onIceHit(BlockDamageEvent event) {
        if (!Config.fastIceBreak) return;

        if (event.isCancelled()) return;

        if (event.getBlock().getType() == Material.ICE) {
            if (!FactionsPlayerListener.canPlayerUseBlock(event.getPlayer(), event.getBlock(), true)) return;
            event.getBlock().breakNaturally();
            event.setCancelled(true);
        }

    }

}
