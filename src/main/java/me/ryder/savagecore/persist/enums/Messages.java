package me.ryder.savagecore.persist.enums;

import me.ryder.savagecore.utils.FileManager.Files;
import me.ryder.savagecore.utils.Methods;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum Messages {

    PREFIX("Messages.Prefix", "&e[!] "),
    NO_PERMISSIONS("Messages.No-Permissions", "&cYou do not have permission to do this."),
    DISABLED_FEATURE("Messages.Disabled-Feature", "&cThis feature has been disabled."),
    ANTI_POST_IP("Messages.Anti-Post-IP", "&cYou can not post personal information in chat."),
    NO_SPAWNER_PROTECTION("Messages.No-Spawner-Protection", "&cYou can not cover up spawners."),
    PLUGIN_RELOAD("Messages.Plugin-Reload", "&cYou have reloaded the plugin."),
    PLAYER_ONLY("Messages.Player-Only", "&cThis command is for players only."),
    CANNOT_STORE_SPAWNERS("Messages.Cannot-Store-Spawners", "&cYou can not store spawners."),
    PLAYER_HELP("Messages.Player-Help",
            Arrays.asList(
                    "&cSavageCore's Help Menu",
                    "",
                    "&c/sc help &8- &7Displays this page to show what you can do.",
                    "&c/sc reload &8- &7Reloads the entire plugin."
            ));

    private String path;
    private String defaultMessage;
    private List<String> defaultListMessage;

    private Messages(String path, String defaultMessage) {
        this.path = path;
        this.defaultMessage = defaultMessage;
    }

    private Messages(String path, List<String> defaultListMessage) {
        this.path = path;
        this.defaultListMessage = defaultListMessage;
    }

    public static String convertList(List<String> list) {
        String message = "";
        for (String line : list) {
            message += Methods.pl(line) + "\n";
        }
        return message;
    }

    public static void addMissingMessages() {
        FileConfiguration messages = Files.messages.getFile();
        boolean saveFile = false;
        for (Messages message : values()) {
            if (!messages.contains("Messages." + message.getPath())) {
                saveFile = true;
                if (message.getDefaultMessage() != null) {
                    messages.set("Messages." + message.getPath(), message.getDefaultMessage());
                } else {
                    messages.set("Messages." + message.getPath(), message.getDefaultListMessage());
                }
            }
        }
        if (saveFile) {
           Files.messages.saveFile();
        }
    }

    public String getMessage() {
        return getMessage(true);
    }

    public String getMessage(String placeholder, String replacement) {
        HashMap<String, String> placeholders = new HashMap<>();
        placeholders.put(placeholder, replacement);
        return getMessage(placeholders, true);
    }

    public String getMessage(HashMap<String, String> placeholders) {
        return getMessage(placeholders, true);
    }

    public String getMessageNoPrefix() {
        return getMessage(false);
    }

    public String getMessageNoPrefix(String placeholder, String replacement) {
        HashMap<String, String> placeholders = new HashMap<>();
        placeholders.put(placeholder, replacement);
        return getMessage(placeholders, false);
    }

    public String getMessageNoPrefix(HashMap<String, String> placeholders) {
        return getMessage(placeholders, false);
    }

    private String getMessage(boolean prefix) {
        return getMessage(new HashMap<>(), prefix);
    }

    private String getMessage(HashMap<String, String> placeholders, boolean prefix) {
        String message;
        boolean isList = isList();
        boolean exists = exists();
        if (isList) {
            if (exists) {
                message = Methods.pl(convertList(Files.messages.getFile().getStringList("Messages." + path)));
            } else {
                message = Methods.pl(convertList(getDefaultListMessage()));
            }
        } else {
            if (exists) {
                message = Methods.pl(Files.messages.getFile().getString("Messages." + path));
            } else {
                message = Methods.pl(getDefaultMessage());
            }
        }
        for (String placeholder : placeholders.keySet()) {
            message = message.replaceAll(placeholder, placeholders.get(placeholder))
                    .replaceAll(placeholder.toLowerCase(), placeholders.get(placeholder));
        }
        if (isList) {
            return Methods.pl(message);
        } else {
            if (prefix) {
                return Methods.getPrefix(message);
            } else {
                return Methods.pl(message);
            }
        }
    }

    private boolean exists() {
        return Files.messages.getFile().contains("Messages." + path);
    }

    private boolean isList() {
        if (Files.messages.getFile().contains("Messages." + path)) {
            return !Files.messages.getFile().getStringList("Messages." + path).isEmpty();
        } else {
            return defaultMessage == null;
        }
    }

    private String getPath() {
        return path;
    }

    private String getDefaultMessage() {
        return defaultMessage;
    }

    private List<String> getDefaultListMessage() {
        return defaultListMessage;
    }
}