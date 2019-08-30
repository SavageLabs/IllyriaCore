package net.savagellc.savagecore.listeners;

import net.savagellc.savagecore.persist.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DenyIPPost implements Listener {

    @EventHandler
    public void onIPPost(AsyncPlayerChatEvent e) {
        String[] parts  = e.getMessage().split(" ");
        Player p = e.getPlayer();
        for (String part : parts) {
            if (this.isValidIP1(part) || this.isValidIP2(part) || this.isValidIP3(part)) {
                e.setCancelled(true);
                p.sendMessage(Messages.prefix + Messages.antiPostIP.toString());
            }
        }
    }

    private boolean isValidIP1(String ip) {
        Pattern pattern = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        Matcher matcher = pattern.matcher(ip);
        return matcher.find();
    }

    private boolean isValidIP2(String ip) {
        Pattern pattern = Pattern.compile("^(\\d{1,3})\\,(\\d{1,3})\\,(\\d{1,3})\\,(\\d{1,3})$");
        Matcher matcher = pattern.matcher(ip);
        return matcher.find();
    }

    private boolean isValidIP3(String ip) {
        Pattern pattern = Pattern.compile("^(\\d{1,3})\\*(\\d{1,3})\\*(\\d{1,3})\\*(\\d{1,3})$");
        Matcher matcher = pattern.matcher(ip);
        return matcher.find();
    }
}