package me.ryder.savagecore.persist;

import net.prosavage.baseplugin.serializer.Serializer;
import net.prosavage.baseplugin.strings.Message;

public class Messages {

    private static transient  Messages instance = new Messages();

    public static Message prefix = new Message("&e[!] ");

    public static Message reload = new Message("&cYou have reloaded the plugin.");

    public static Message noPerms = new Message("&cYou do not have enough permission to use this.");

    public static Message disabled = new Message("&cThis feature has been disabled.");

    public static Message antiIP = new Message("&cYou can not post personal information in chat!");

    public static Message no_spawner_protect = new Message("&cYou can not cover up spawners");

    public static void save() {
        new Serializer().save(instance);
    }

    public static void load() {
        new Serializer().load(instance, Messages.class, "messages");
    }
}