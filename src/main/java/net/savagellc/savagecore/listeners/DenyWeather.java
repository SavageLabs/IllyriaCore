package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class DenyWeather implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onWeatherChange(WeatherChangeEvent e) {
        if (Config.denyWeather) {
            if (e.toWeatherState()) {
                if (Config.denyWeatherInWorlds.contains(e.getWorld().getName())) {
                    e.getWorld().setWeatherDuration(0);
                    e.setCancelled(true);
                }
            }
        }
    }
}