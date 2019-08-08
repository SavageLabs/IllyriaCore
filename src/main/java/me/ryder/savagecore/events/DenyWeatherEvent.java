package me.ryder.savagecore.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import me.ryder.savagecore.persist.Config;

public class DenyWeatherEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onWeatherChange(WeatherChangeEvent e) {
        if (Config.weatherToggle) {
            if (e.toWeatherState()) {
                if (Config.noWeatherInWorlds.contains(e.getWorld().getName())) {
                    e.getWorld().setWeatherDuration(0);
                    e.setCancelled(true);
                }
            }
        }
    }
}