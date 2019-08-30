package net.savagellc.savagecore.utils;

import net.savagellc.savagecore.persist.Conf;
import org.bukkit.ChatColor;

public class Methods {

    public static String pl(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String getPrefix(String msg) {
        return pl(FileManager.Files.messages.getFile().getString("Messages.Prefix") + msg);
    }

    public static void reloadConfiguration() {
        Conf.load();
        FileManager.Files.messages.reloadFile();
    }
}