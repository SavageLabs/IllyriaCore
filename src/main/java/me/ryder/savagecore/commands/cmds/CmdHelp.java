package me.ryder.savagecore.commands.cmds;

import me.ryder.savagecore.SavageCore;
import me.ryder.savagecore.commands.AbstractCommand;
import me.ryder.savagecore.persist.enums.Messages;
import org.bukkit.command.CommandSender;

public class CmdHelp extends AbstractCommand {

    public CmdHelp(SavageCore plugin) {
        super(plugin, "help", false);
    }

    public boolean execute(CommandSender s, String[] args) {
        s.sendMessage(Messages.PLAYER_HELP.getMessage());
        return false;
    }

    public String getDescription() {
        return "A view of all SavageCore's Commands";
    }

    public String getPermission() {
        return "savagecore.view";
    }
}