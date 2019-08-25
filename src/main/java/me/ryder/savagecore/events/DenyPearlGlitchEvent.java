package me.ryder.savagecore.events;

import me.ryder.savagecore.persist.Conf;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Objects;

public class DenyPearlGlitchEvent implements Listener {

    @EventHandler
    public void onPearlTeleport(PlayerTeleportEvent event) {

        if (Conf.pearlGlitchFix) {
            if (event.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
                Location to = event.getTo();
                if (Objects.requireNonNull(to).getBlock().getRelative(BlockFace.UP).getType().isSolid()) {
                    event.setCancelled(true);
                    event.getPlayer().getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
                }
            }
        }
    }
}