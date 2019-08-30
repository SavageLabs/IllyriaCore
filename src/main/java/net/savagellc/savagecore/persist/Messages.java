package net.savagellc.savagecore.persist;

import net.prosavage.baseplugin.serializer.Serializer;
import net.prosavage.baseplugin.strings.Message;

public class Messages {

    private static transient Messages instance = new Messages();

    public static Message prefix = new Message("&c[!] ");

    public static Message reloadConfig = new Message("&7You have reloaded the configuration files!");

    public static Message noPermissions = new Message("&7You do not have enough permissions!");

    public static Message disabledFeature = new Message("&7This feature has been disabled.");

    public static Message antiPostIP = new Message("&7You can not post personal information in chat.");

    public static Message noSpawnerProtection = new Message("&7You can not cover up spawners.");

    public static Message cannotStoreSpawners = new Message("&7You can not store spawners.");

    public static Message playerOnly = new Message("&7This command is for players only.");

    public static void save() {
        new Serializer().save(instance);
    }

    public static void load() {
        new Serializer().load(instance, Messages.class, "messages");
    }
}