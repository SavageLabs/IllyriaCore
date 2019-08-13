package me.ryder.savagecore.utils;

import me.ryder.savagecore.persist.Config;
import me.ryder.savagecore.utils.FileManager.Files;
import org.bukkit.ChatColor;

public class Methods {

    public static String pl(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String getPrefix(String msg) {
        return pl(Files.messages.getFile().getString("Messages.Prefix") + msg);
    }

    public static void reloadConfiguration() {
        Config.load();
        Files.messages.reloadFile();
    }
}