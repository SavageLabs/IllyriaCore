package net.savagellc.savagecore;

import net.prosavage.baseplugin.BasePlugin;
import net.savagellc.savagecore.commands.BaseCommand;
import net.savagellc.savagecore.listener.*;
import net.savagellc.savagecore.listener.autorespawn.AutoRespawnListener;
import net.savagellc.savagecore.listener.factions.AntiWildernessSpawner;
import net.savagellc.savagecore.listener.mobs.FastIronGolemDeath;
import net.savagellc.savagecore.listener.player.BloodSprayListener;
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
    }

    private void loadCmds() {
        this.command = new BaseCommand(this);
        Objects.requireNonNull(getCommand("savagecore")).setExecutor(this.command);
    }

    private void loadLists() {
        registerListeners(new DenyItemBurnListener(),
                new DenyIceMeltListener(),
                new DenyBabyMobListener(),
                new DenyWeatherListener(),
                new DenyEndermanListener(),
                new DenyFireSpreadListener(),
                new DenyBlazeDrowning(),
                new DenyWaterRedstone(),
                new DenyIPPostListener(),
                new DenySpawnerStorage(),
                new DenySpawnerGuard(),
                new FastIronGolemDeath(),
                new FastIceBreakListener(),
                new AutoRespawnListener(),
                new AntiWildernessSpawner(),
                new DenyPearlGlitchListener(),
                new BloodSprayListener());

    }
}