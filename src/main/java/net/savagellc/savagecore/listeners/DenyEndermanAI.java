package net.savagellc.savagecore.listeners;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;
import net.savagellc.savagecore.persist.Config;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

public class DenyEndermanAI implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEntityChangeBlock(EntityChangeBlockEvent e) {
        if (Config.denyEndermanGrief) {
            if (isEM(e.getEntity())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEnderManTeleport(EntityTeleportEvent e) {
        FLocation loc = new FLocation(e.getEntity().getLocation());
        Faction faction = Board.getInstance().getFactionAt(loc);
        if (Config.denyEndermanTeleport) {
            if (faction.isWilderness() || faction.isSafeZone() || faction.isWarZone()) { return; }
            if (faction.isNormal() || faction.isPeaceful()) {
                if (isEM(e.getEntity())) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onTarget(EntityTargetEvent e) {
        if (Config.denyEndermanTarget) {
            if (isEM(e.getEntity()) && e.getTarget() instanceof Player) {
                if (e.getReason() == EntityTargetEvent.TargetReason.CLOSEST_PLAYER) {
                    e.setCancelled(true);
                }
            }
        }
    }

    private boolean isEM(Entity e) { return e.getType() == EntityType.ENDERMAN; }
}