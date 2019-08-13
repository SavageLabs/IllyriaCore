package me.ryder.savagecore.persist;

import net.prosavage.baseplugin.serializer.Serializer;

import java.util.*;

public class Config {

    private static transient Config instance = new Config();

    public static boolean fireSpreadToggle = false;

    public static boolean iceMeltToggle = false;

    public static boolean enderManGriefToggle = false;

    public static boolean antiBlazeDrownToggle = false;

    public static boolean noPoppyDropToggle = false;

    public static boolean fastIronGolemDeath = false;

    public static boolean antiWildernessSpawner = false;

    public static boolean babyMobToggle = false;

    public static boolean bloodSprayToggle = false;

    public static boolean respawnScreenToggle = false;

    public static boolean itemBurnToggle = false;

    public static Set<String> damageTypes = new LinkedHashSet<>();

    public static boolean noWaterItemsToggle = false;

    public static Set<String> itemTypes = new LinkedHashSet<>();

    public static boolean weatherToggle = false;

    public static Set<String> noWeatherInWorlds = new LinkedHashSet<>();

    public static boolean pearlGlitchFix = false;

    public static boolean fastIceBreak = false;

    static {
        damageTypes.add("FIRE_TICK");
        damageTypes.add("FIRE");
        damageTypes.add("LAVA");
        damageTypes.add("BLOCK_EXPLOSION");
        damageTypes.add("LIGHTNING");
        damageTypes.add("ENTITY_EXPLOSION");

        itemTypes.add("REDSTONE");
        itemTypes.add("TORCH");

        noWeatherInWorlds.add("world");
    }

    public static void save() {
        new Serializer().save(instance);
    }

    public static void load() {
        new Serializer().load(instance, Config.class, "config");
    }
}