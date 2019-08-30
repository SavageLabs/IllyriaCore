package net.savagellc.savagecore.persist.settings;

import net.savagellc.savagecore.events.mobs.FastIronGolemDeath;

public class FastIronGolemDeathSettings {

    public boolean toggle;
    public int damage;

    public FastIronGolemDeathSettings(boolean toggle, int damage) {
        this.toggle = toggle;
        this.damage = damage;
    }



}
