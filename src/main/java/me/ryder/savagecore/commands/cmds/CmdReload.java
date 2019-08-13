package me.ryder.savagecore.commands.cmds;

import me.ryder.savagecore.SavageCore;
import me.ryder.savagecore.commands.AbstractCommand;
import me.ryder.savagecore.persist.Config;
import me.ryder.savagecore.persist.enums.Messages;
import me.ryder.savagecore.utils.FileManager;
import org.bukkit.command.CommandSender;

public class CmdReload extends AbstractCommand {

    public CmdReload(SavageCore plugin) {
        super(plugin, "reload", false);
    }

    public boolean execute(CommandSender s, String[] args) {
        FileManager.Files.messages.reloadFile();
        Config.load();

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