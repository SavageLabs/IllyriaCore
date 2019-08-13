package me.ryder.savagecore.commands;

import org.bukkit.command.CommandSender;

public interface Executable {

    boolean execute(CommandSender paramCommandSender, String[] paramArrayOfString);

    String getDescription();

    String getPermission();
}