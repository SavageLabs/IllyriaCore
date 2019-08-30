package net.savagellc.savagecore.listeners.autorespawn;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent;
import java.util.Objects;

public class PreAutoRespawn extends Event implements Cancellable {
    private Player p;
    private Location dl;
    private boolean cl;
    private static HandlerList handlers;

    static {
        handlers = new HandlerList();
    }

    PreAutoRespawn(Player p, Location dl) {
        this.cl = false;
        this.p = p;
        this.dl = dl;
    }

    public Player getPlayer() {
        return this.p;
    }

    public Location getDl() {
        return this.dl;
    }

    public EntityDamageEvent.DamageCause getDeathCause() {
        return Objects.requireNonNull(this.p.getLastDamageCause()).getCause();
    }

    public boolean kbp() {
        return Objects.requireNonNull(this.p.getLastDamageCause()).getEntity() instanceof Player || (this.p.getLastDamageCause().getEntity() instanceof Projectile && ((Projectile) this.p.getLastDamageCause().getEntity()).getShooter() instanceof Player);
    }

    public Player gk() {
        return this.p.getKiller();
    }

    public HandlerList getHandlers() {
        return PreAutoRespawn.handlers;
    }

    public static HandlerList getHL() {
        return PreAutoRespawn.handlers;
    }

    public boolean isCancelled() {
        return this.cl;
    }

    public void setCancelled( boolean arg0) {
        this.cl = arg0;
    }
}