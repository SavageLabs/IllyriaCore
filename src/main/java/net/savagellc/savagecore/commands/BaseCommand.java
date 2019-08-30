package net.savagellc.savagecore.commands;

import net.savagellc.savagecore.SavageCore;
import net.savagellc.savagecore.commands.cmds.CmdHelp;
import net.savagellc.savagecore.commands.cmds.CmdReload;
import net.savagellc.savagecore.persist.enums.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.*;

public class BaseCommand implements CommandExecutor {
    public Map<Class, AbstractCommand> subcommands;
    private SavageCore plugin;

    public BaseCommand(SavageCore plugin) {
        this.subcommands = new HashMap<>();

        this.plugin = plugin;
        addCommand(new CmdReload(plugin));
        addCommand(new CmdHelp(plugin));
    }

    public boolean onCommand(CommandSender s, Command cmd, String string, String[] args) {
        try {
            if (args.length == 0) {
                AbstractCommand helpCommand = (AbstractCommand)this.subcommands.get(Class.forName("net.savagellc.savagecore.commands.cmds.CmdHelp"));
                if (s.hasPermission(helpCommand.getPermission())) {
                    ((AbstractCommand)this.subcommands.get(Class.forName("net.savagellc.savagecore.commands.cmds.CmdHelp"))).execute(s, args);
                    return false;
                }
                s.sendMessage(Messages.NO_PERMISSIONS.getMessage());
                return false;
            }

            for (AbstractCommand abstractCommand : this.subcommands.values()) {
                if (!(s instanceof Player) && abstractCommand.isPlayerRequired()) {
                    s.sendMessage(Messages.PLAYER_ONLY.getMessage());
                    return false;
                }
                if (args[0].equalsIgnoreCase(abstractCommand.getLabel()) || abstractCommand.alias.contains(args[0])) {
                    if (s.hasPermission(abstractCommand.getPermission()) || s.isOp()) {
                        return abstractCommand.execute(s, (String[])Arrays.copyOfRange(args, 1, args.length));
                    }
                    s.sendMessage(Messages.NO_PERMISSIONS.getMessage());
                    return false;
                }
            }
            return false;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void addCommand(AbstractCommand cmd) {
        this.subcommands.put(cmd.getClass(), cmd);
    }

    public Collection<AbstractCommand> getCommands() {
        return Collections.unmodifiableCollection(this.subcommands.values());
    }
}