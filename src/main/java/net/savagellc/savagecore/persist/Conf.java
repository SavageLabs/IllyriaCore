package net.savagellc.savagecore.persist;

import net.prosavage.baseplugin.serializer.Serializer;
import net.savagellc.savagecore.persist.settings.FastIronGolemDeathSettings;
import net.savagellc.savagecore.persist.settings.NoHitDelaySettings;

import java.util.*;

public class Conf {

    private static transient Conf instance = new Conf();

    public static boolean bloodSprayToggle = false;

    public static boolean fastIceBreak = false;

    public static boolean denyPearlGlitch = false;

    public static boolean denyFireSpread = false;

    public static boolean denyIceMelt = false;

    public static boolean denyEndermanGrief = false;

    public static boolean denyEndermanTeleport = false;

    public static boolean denyEndermanTarget = false;

    public static boolean denyBlazeDrowning = false;

    public static boolean denyPoppyDrops = false;

    public static boolean denyWildernessSpawners = false;

    public static boolean denyBabyMobs = false;

    public static boolean denySpawnerStorage = false;

    public static boolean denySpawnerProtection = false;

    public static boolean denyMobItemPickup = false;

    public static boolean denyRespawnScreen = false;

    public static boolean denyItemBurn = false;

    public static FastIronGolemDeathSettings fastIronGolemDeathSettings = new FastIronGolemDeathSettings(false, 20);

    public static NoHitDelaySettings noHitDelaySettings = new NoHitDelaySettings(false, 20);

    public static Set<String> itemBurnTypes = new LinkedHashSet<>();

    static {
        itemBurnTypes.add("FIRE_TICK");
        itemBurnTypes.add("FIRE");
        itemBurnTypes.add("LAVA");
        itemBurnTypes.add("BLOCK_EXPLOSION");
        itemBurnTypes.add("ENTITY_EXPLOSION");
    }

    public static boolean denyWaterItemBreak = false;

    public static Set<String> itemWaterDeny = new LinkedHashSet<>();

    static {
        itemWaterDeny.add("TORCH");
        itemWaterDeny.add("REDSTONE_TORCH");
        itemWaterDeny.add("REDSTONE");
    }

    public static boolean denyWeather = false;

    public static Set<String> denyWeatherInWorlds = new LinkedHashSet<>();

    static {
        denyWeatherInWorlds.add("world");
    }

    public static void save() {
        new Serializer().save(instance);
    }

    public static void load() {
        new Serializer().load(instance, Conf.class, "conf");
    }
}