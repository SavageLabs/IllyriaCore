package net.savagellc.savagecore.commands.cmds;

import net.savagellc.savagecore.SavageCore;
import net.savagellc.savagecore.commands.AbstractCommand;
import net.savagellc.savagecore.persist.Config;
import net.savagellc.savagecore.persist.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdReload extends AbstractCommand {

    public CmdReload(SavageCore plugin) {
        super(plugin, "reload", false);
    }

    public boolean execute(CommandSender s, String[] args) {
        Messages.load();
        Config.load();
        if (Config.noHitDelaySettings.toggle) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setMaximumNoDamageTicks(Config.noHitDelaySettings.delay);
            }
        }
        s.sendMessage(Messages.prefix + Messages.reloadConfig.toString());
        return false;
    }

    public String getDescription() {
        return "This will reload the entire plugin";
    }

    public String getPermission() {
        return "savagecore.reload";
    }
}