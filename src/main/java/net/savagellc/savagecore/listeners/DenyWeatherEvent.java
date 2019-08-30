package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Conf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class DenyWeatherEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onWeatherChange(WeatherChangeEvent e) {
        if (Conf.weatherToggle) {
            if (e.toWeatherState()) {
                if (Conf.noWeatherInWorlds.contains(e.getWorld().getName())) {
                    e.getWorld().setWeatherDuration(0);
                    e.setCancelled(true);
                }
            }
        }
    }
}