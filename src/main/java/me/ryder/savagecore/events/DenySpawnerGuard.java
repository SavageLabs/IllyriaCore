package me.ryder.savagecore.events;

import me.ryder.savagecore.persist.Messages;
import net.prosavage.baseplugin.XMaterial;
import org.bukkit.ChatColor;
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

    @EventHandler
    public void spawnerPlacement(PlayerInteractEvent event) {
        if (event.isCancelled()) return;

        Player player = event.getPlayer();

        if (player.getItemInHand() == null) return;

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (!player.getItemInHand().getType().equals(spawner)) {
                if (event.getBlockFace().equals(BlockFace.UP) || event.getBlockFace().equals(BlockFace.DOWN)) return;

                if (!event.getClickedBlock().getType().equals(spawner)) return;

                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.no_spawner_protect.toString()));
            } else if (player.getItemInHand().getType().equals(spawner)) {
                if (event.getClickedBlock().getType().equals(spawner)) return;

                if (event.getBlockFace().equals(BlockFace.UP) || event.getBlockFace().equals(BlockFace.DOWN)) return;

                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.no_spawner_protect.toString()));
            }
        }
    }

    @EventHandler
    public void spawnerProtectionCheck(BlockPlaceEvent event) {

        if (event.isCancelled()) return;

        Block blockPlaced = event.getBlockPlaced();
        Player player = event.getPlayer();

        if (blockPlaced == null) return;

        if (blockPlaced.getType() == spawner) {
            for (BlockFace blockFace : Arrays.asList(BlockFace.WEST, BlockFace.EAST, BlockFace.SOUTH, BlockFace.NORTH)) {
                if (event.getBlockPlaced().getRelative(blockFace).getType() != spawner) {
                    if (event.getBlockPlaced().getRelative(blockFace).getType() != Material.AIR) {
                        event.setCancelled(true);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.no_spawner_protect.toString()));
                        return;
                    }
                }
            }
        } else if (blockPlaced.getType() != spawner) {

            for (BlockFace blockFace : Arrays.asList(BlockFace.WEST, BlockFace.EAST, BlockFace.SOUTH, BlockFace.NORTH)) {
                if (event.getBlockPlaced().getRelative(blockFace).getType() == spawner) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.no_spawner_protect.toString()));
                    return;
                }
            }

        }
    }


}
