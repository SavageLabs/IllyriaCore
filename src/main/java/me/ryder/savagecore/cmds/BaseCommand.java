package me.ryder.savagecore.cmds;

import me.ryder.savagecore.utils.Methods;
import me.ryder.savagecore.persist.Config;
import me.ryder.savagecore.persist.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BaseCommand implements CommandExecutor {

    private int delay;

    public void setDelay(int delay) {
        this.delay = Config.delay;
    }

    private void reloadConfiguration() {
        Config.load();
        Messages.load();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (!sender.hasPermission("savagecore.info")) {
                sender.sendMessage(Messages.prefix + Messages.noPerms.toString());
            }
            sender.sendMessage(Methods.pl("&cThis shows a list of commands."));
            sender.sendMessage(Methods.pl("&8- &c/sc reload &7This will reload the plugin."));
        } else {
            if (args[0].equalsIgnoreCase("reload")) {
                if (!sender.hasPermission("savagecore.reload")) {
                    sender.sendMessage(Messages.prefix + Messages.noPerms.toString());
                }
                reloadConfiguration();
                sender.sendMessage(Messages.prefix + Messages.reload.toString());
                return true;
            }
        }
        return true;
    }
}
