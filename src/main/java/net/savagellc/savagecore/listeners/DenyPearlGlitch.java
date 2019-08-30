package net.savagellc.savagecore.listeners;

import net.prosavage.baseplugin.XMaterial;
import net.savagellc.savagecore.persist.Conf;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Objects;

public class DenyPearlGlitch implements Listener {

    @EventHandler
    public void onPearlTeleport(PlayerTeleportEvent e) {
        Player p = e.getPlayer();
        Material ep = XMaterial.ENDER_PEARL.parseMaterial();
        if (Conf.denyPearlGlitch) {
            if (e.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
                Location to = e.getTo();
                if (Objects.requireNonNull(to).getBlock().getRelative(BlockFace.UP).getType().isSolid()) {
                    e.setCancelled(true);
                    p.getInventory().addItem(new ItemStack(ep));
                }
            }
        }
    }
}