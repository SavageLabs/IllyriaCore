package me.ryder.savagecore.events.factions;

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.Faction;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import me.ryder.savagecore.persist.Conf;

public class AntiWildernessSpawner implements Listener {

    @EventHandler
    public void onSpawnerSpawn(SpawnerSpawnEvent e) {

        if (Conf.antiWildernessSpawner) {
            FLocation loc = new FLocation(e.getSpawner().getLocation());

            Faction faction = Board.getInstance().getFactionAt(loc);

            if (faction == null) {
                return;
            }

            if (faction.isWilderness()) {
                e.setCancelled(true);
            }
        }
    }
}