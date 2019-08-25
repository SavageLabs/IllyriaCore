package me.ryder.savagecore.events;

import me.ryder.savagecore.persist.Conf;
import me.ryder.savagecore.persist.enums.Messages;
import net.prosavage.baseplugin.XMaterial;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.Arrays;

public class DenySpawnerGuard implements Listener {

    private Material spawner = XMaterial.SPAWNER.parseMaterial();
    @SuppressWarnings("deprecation")
    @EventHandler
    public void spawnerPlacement(PlayerInteractEvent e) {

        if (!Conf.preventSpawnerProtection) return;

        if (e.isCancelled()) return;

        Player player = e.getPlayer();

        if (player.getItemInHand() == null) return;

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (!player.getItemInHand().getType().equals(spawner)) {
                if (e.getBlockFace().equals(BlockFace.UP) || e.getBlockFace().equals(BlockFace.DOWN)) return;

                if (!e.getClickedBlock().getType().equals(spawner)) return;

                e.setCancelled(true);
                player.sendMessage(Messages.NO_SPAWNER_PROTECTION.getMessage());
            } else if (player.getItemInHand().getType().equals(spawner)) {
                if (e.getClickedBlock().getType().equals(spawner)) return;

                if (e.getBlockFace().equals(BlockFace.UP) || e.getBlockFace().equals(BlockFace.DOWN)) return;
                e.setCancelled(true);
                player.sendMessage(Messages.NO_SPAWNER_PROTECTION.getMessage());
            }
        }
    }

    @EventHandler
    public void spawnerProtectionCheck(BlockPlaceEvent e) {

        if (!Conf.preventSpawnerProtection) return;

        if (e.isCancelled()) return;

        Block blockPlaced = e.getBlockPlaced();
        Player player = e.getPlayer();

        if (blockPlaced == null) return;

        if (blockPlaced.getType() == spawner) {
            for (BlockFace blockFace : Arrays.asList(BlockFace.WEST, BlockFace.EAST, BlockFace.SOUTH, BlockFace.NORTH)) {
                if (e.getBlockPlaced().getRelative(blockFace).getType() != spawner) {
                    if (e.getBlockPlaced().getRelative(blockFace).getType() != Material.AIR) {
                        e.setCancelled(true);
                        player.sendMessage(Messages.NO_SPAWNER_PROTECTION.getMessage());
                        return;
                    }
                }
            }
        } else if (blockPlaced.getType() != spawner) {

            for (BlockFace blockFace : Arrays.asList(BlockFace.WEST, BlockFace.EAST, BlockFace.SOUTH, BlockFace.NORTH)) {
                if (e.getBlockPlaced().getRelative(blockFace).getType() == spawner) {
                    e.setCancelled(true);
                    player.sendMessage(Messages.NO_SPAWNER_PROTECTION.getMessage());
                    return;
                }
            }
        }
    }
}