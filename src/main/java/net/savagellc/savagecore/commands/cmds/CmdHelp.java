package net.savagellc.savagecore.commands.cmds;

import net.savagellc.savagecore.SavageCore;
import net.savagellc.savagecore.commands.AbstractCommand;
import net.savagellc.savagecore.utils.Methods;
import org.bukkit.command.CommandSender;

public class CmdHelp extends AbstractCommand {

    public CmdHelp(SavageCore plugin) {
        super(plugin, "help", false);
    }

    public boolean execute(CommandSender s, String[] args) {
        s.sendMessage(Methods.pl("&cSavageCore's Help Menu"));
        s.sendMessage(Methods.pl(""));
        s.sendMessage(Methods.pl("&c/savagecore help &8- &7Displays this page to show what you can do."));
        s.sendMessage(Methods.pl("&c/savagecore reload &8- &7Reloads the entire plugin."));
        s.sendMessage(Methods.pl(""));
        s.sendMessage(Methods.pl("&7Its recommended to shut down the server before editing but reload should work."));
        return false;
    }

    public String getDescription() {
        return "A view of all SavageCore's Commands";
    }

    public String getPermission() {
        return "savagecore.view";
    }
}