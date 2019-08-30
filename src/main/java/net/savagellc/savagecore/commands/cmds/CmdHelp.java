package net.savagellc.savagecore.commands.cmds;

import net.savagellc.savagecore.SavageCore;
import net.savagellc.savagecore.commands.AbstractCommand;
import net.savagellc.savagecore.persist.enums.Messages;
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