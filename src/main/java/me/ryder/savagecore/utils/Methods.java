package me.ryder.savagecore.utils;

import me.ryder.savagecore.persist.Config;
import me.ryder.savagecore.persist.Messages;
import org.bukkit.ChatColor;

public class Methods {

    public static String pl(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    public static void reloadConfiguration() {
        Config.load();
        Messages.load();
    }
}