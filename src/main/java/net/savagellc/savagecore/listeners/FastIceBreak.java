package net.savagellc.savagecore.listeners;

import com.massivecraft.factions.listeners.FactionsPlayerListener;
import net.prosavage.baseplugin.XMaterial;
import net.savagellc.savagecore.persist.Conf;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class FastIceBreak implements Listener {

    @EventHandler
    public void onIceHit(BlockDamageEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        Material ice = XMaterial.ICE.parseMaterial();
        if (!Conf.fastIceBreak) return;

        if (e.isCancelled()) return;

        if (block.getType() == ice) {
            if (!FactionsPlayerListener.canPlayerUseBlock(player, block, true)) return;
            block.breakNaturally();
            e.setCancelled(true);
        }
    }
}