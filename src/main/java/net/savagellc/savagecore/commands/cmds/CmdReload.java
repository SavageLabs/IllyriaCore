package net.savagellc.savagecore.commands.cmds;

import net.savagellc.savagecore.SavageCore;
import net.savagellc.savagecore.commands.AbstractCommand;
import net.savagellc.savagecore.persist.Conf;
import net.savagellc.savagecore.persist.enums.Messages;
import net.savagellc.savagecore.utils.FileManager;
import org.bukkit.command.CommandSender;

public class CmdReload extends AbstractCommand {

    public CmdReload(SavageCore plugin) {
        super(plugin, "reload", false);
    }

    public boolean execute(CommandSender s, String[] args) {
        FileManager.Files.messages.reloadFile();
        FileManager.Files.config.reloadFile();
        Conf.load();

        s.sendMessage(Messages.PLUGIN_RELOAD.getMessage());
        return false;
    }

    public String getDescription() {
        return "This will reload the entire plugin";
    }

    public String getPermission() {
        return "savagecore.reload";
    }
}