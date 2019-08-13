package me.ryder.savagecore.events;

import me.ryder.savagecore.persist.Config;
import net.prosavage.baseplugin.XMaterial;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DenySpawnerStorage implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if (!Config.preventSpawnerStorage) return;

        if (event.isCancelled()) return;

        Inventory clicked = event.getClickedInventory();

        if (event.getClick().isShiftClick()) {
            if (clicked == event.getWhoClicked().getInventory()) {
                ItemStack clickedOn = event.getCurrentItem();
                if (clickedOn != null && clickedOn.getType() == XMaterial.SPAWNER.parseItem().getType()) {
                    event.setCancelled(true);
                }
            }
        }

        if (clicked != event.getWhoClicked().getInventory()) {
            ItemStack onCursor = event.getCursor();
            if (onCursor != null && onCursor.getType() == XMaterial.SPAWNER.parseItem().getType()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {

        if (!Config.preventSpawnerStorage) return;

        if (event.isCancelled()) return;

        ItemStack dragged = event.getOldCursor();
        if (dragged.getType() == XMaterial.SPAWNER.parseItem().getType()) {
            int inventorySize = event.getInventory().getSize();
            for (int i : event.getRawSlots()) {
                if (i < inventorySize) {
                    event.setCancelled(true);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onHopperMoveEvent(InventoryMoveItemEvent event) {

        if (!Config.preventSpawnerStorage) return;

        if (event.isCancelled()) return;

        if (event.getItem().getType() == XMaterial.SPAWNER.parseItem().getType()) {
            event.setCancelled(true);
        }
    }

}
