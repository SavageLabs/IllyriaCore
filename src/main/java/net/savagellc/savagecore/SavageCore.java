package net.savagellc.savagecore;

import net.prosavage.baseplugin.BasePlugin;
import net.savagellc.savagecore.commands.BaseCommand;
import net.savagellc.savagecore.events.*;
import net.savagellc.savagecore.events.autorespawn.AutoRespawnEvent;
import net.savagellc.savagecore.events.factions.AntiWildernessSpawner;
import net.savagellc.savagecore.events.mobs.FastIronGolemDeath;
import net.savagellc.savagecore.events.player.BloodSprayEvent;
import net.savagellc.savagecore.persist.Conf;
import net.savagellc.savagecore.utils.FileManager;
import net.savagellc.savagecore.utils.FileManager.Files;
import org.bukkit.event.Listener;

import java.util.Objects;
import java.util.logging.Logger;

public final class SavageCore extends BasePlugin implements Listener {
    public static Logger logger;
    private FileManager fm = FileManager.getInstance();
    public BaseCommand command;

    @Override
    public void onEnable() {
        super.onEnable();
        loadData();
        loadLists();
        loadCmds();
    }

    @Override
    public void onDisable() {
        saveData();
    }

    private void loadData() {
        Conf.load();
        fm.logInfo(true).setup(this);
    }

    private void saveData() {
        Conf.save();
        Files.messages.saveFile();
        Files.config.saveFile();
    }

    private void loadCmds() {
        this.command = new BaseCommand(this);
        Objects.requireNonNull(getCommand("savagecore")).setExecutor(this.command);
    }

    private void loadLists() {
        registerListeners(new DenyItemBurnEvent(),
                new DenyIceMeltEvent(),
                new DenyBabyMobEvent(),
                new DenyWeatherEvent(),
                new DenyEndermanEvent(),
                new DenyFireSpreadEvent(),
                new DenyBlazeDrowning(),
                new DenyWaterRedstone(),
                new DenyIPPostEvent(),
                new DenySpawnerStorage(),
                new DenySpawnerGuard(),
                new FastIronGolemDeath(),
                new FastIceBreakEvent(),
                new AutoRespawnEvent(),
                new AntiWildernessSpawner(),
                new DenyPearlGlitchEvent(),
                new BloodSprayEvent());

    }
}