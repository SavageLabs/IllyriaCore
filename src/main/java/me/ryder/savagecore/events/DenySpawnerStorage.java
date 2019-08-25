package me.ryder.savagecore.events;

import me.ryder.savagecore.persist.Conf;
import me.ryder.savagecore.persist.enums.Messages;
import net.prosavage.baseplugin.XMaterial;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DenySpawnerStorage implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if (!Conf.preventSpawnerStorage) return;

        if (e.isCancelled()) return;

        Inventory clicked = e.getClickedInventory();
        Player player = (Player) e.getWhoClicked();

        if (e.getClick().isShiftClick()) {
            if (clicked == e.getWhoClicked().getInventory()) {
                ItemStack clickedOn = e.getCurrentItem();
                if (clickedOn != null && clickedOn.getType() == XMaterial.SPAWNER.parseItem().getType()) {
                    player.sendMessage(Messages.CANNOT_STORE_SPAWNERS.getMessage());
                    e.setCancelled(true);
                }
            }
        }

        if (clicked != e.getWhoClicked().getInventory()) {
            ItemStack onCursor = e.getCursor();
            if (onCursor != null && onCursor.getType() == XMaterial.SPAWNER.parseItem().getType()) {
                player.sendMessage(Messages.CANNOT_STORE_SPAWNERS.getMessage());
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (!Conf.preventSpawnerStorage) return;

        if (e.isCancelled()) return;

        ItemStack dragged = e.getOldCursor();
        if (dragged.getType() == XMaterial.SPAWNER.parseItem().getType()) {
            int inventorySize = e.getInventory().getSize();
            for (int i : e.getRawSlots()) {
                if (i < inventorySize) {
                    player.sendMessage(Messages.CANNOT_STORE_SPAWNERS.getMessage());
                    e.setCancelled(true);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onHopperMoveEvent(InventoryMoveItemEvent e) {

        if (!Conf.preventSpawnerStorage) return;

        if (e.isCancelled()) return;

        if (e.getItem().getType() == XMaterial.SPAWNER.parseItem().getType()) {
            e.setCancelled(true);
        }
    }
}