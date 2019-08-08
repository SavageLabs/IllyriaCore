package me.ryder.savagecore.events.autorespawn;

import org.bukkit.event.Event;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent;
import java.util.Objects;

public class TargetAutoRespawnEvent extends Event {
    private Player p;
    private Location dl;
    private Location rl;
    private static HandlerList handlers;

    static {
        handlers = new HandlerList();
    }

    TargetAutoRespawnEvent(Player p, Location dl, Location rl) {
        this.p = p;
        this.rl = rl;
        this.dl = dl;
    }

    public Player getPlayer() {
        return this.p;
    }

    public Location getDeathLocation() {
        return this.dl;
    }

    public Location getRespawnLocation() {
        return this.rl;
    }

    public EntityDamageEvent.DamageCause getDeathCause() {
        return Objects.requireNonNull(this.p.getLastDamageCause()).getCause();
    }

    public boolean killedByPlayer() {
        if (Objects.requireNonNull(this.p.getLastDamageCause()).getEntity() instanceof Player) {
            return true;
        }
        if (this.p.getLastDamageCause().getEntity() instanceof Projectile) {
            Projectile a = (Projectile) this.p.getLastDamageCause().getEntity();
            return a.getShooter() instanceof Player;
        }
        return false;
    }

    public Player getKiller() {
        return this.p.getKiller();
    }

    public HandlerList getHandlers() {
        return TargetAutoRespawnEvent.handlers;
    }

    public static HandlerList getHandlerList() {
        return TargetAutoRespawnEvent.handlers;
    }
}