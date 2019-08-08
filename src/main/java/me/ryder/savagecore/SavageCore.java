package me.ryder.savagecore;

import me.ryder.savagecore.cmds.BaseCommand;
import me.ryder.savagecore.events.*;
import me.ryder.savagecore.events.autorespawn.AutoRespawnEvent;
import me.ryder.savagecore.events.factions.AntiWildernessSpawner;
import me.ryder.savagecore.events.factions.FastGolemDeathEvent;
import me.ryder.savagecore.events.player.BloodSprayEvent;
import me.ryder.savagecore.persist.Config;
import me.ryder.savagecore.persist.Messages;
import net.prosavage.baseplugin.BasePlugin;
import org.bukkit.event.Listener;

import java.util.Objects;

public final class SavageCore extends BasePlugin implements Listener {

    @Override
    public void onEnable() {
        super.onEnable();
        getLogger().info("SavageFactions is needed to run this plugin, Certain features will still work but it will throw errors.");
        loadData();
        loadLists();
        loadCmds();
    }

    @Override
    public void onDisable() {
        saveData();
    }

    private void loadData() {
        Config.load();
        Messages.load();

    }
    private void saveData() {
        Config.save();
        Messages.save();
    }

    private void loadCmds() {
        Objects.requireNonNull(getCommand("sc")).setExecutor(new BaseCommand());
    }

    private void loadLists() {
        registerListeners(new DenyItemBurnEvent());
        registerListeners(new DenyIceMeltEvent());
        registerListeners(new DenyBabyMobEvent());
        registerListeners(new DenyWeatherEvent());
        registerListeners(new DenyEndermanEvent());
        registerListeners(new DenyFireSpreadEvent());
        registerListeners(new DenyBlazeDrowning());
        registerListeners(new DenyPoppyDropEvent());
        registerListeners(new DenyWaterRedstone());

        registerListeners(new AutoRespawnEvent());

        // Faction Checks
        registerListeners(new AntiWildernessSpawner());
        registerListeners(new FastGolemDeathEvent());

        // PVP / Player Based Checks
        registerListeners(new BloodSprayEvent());
    }
}