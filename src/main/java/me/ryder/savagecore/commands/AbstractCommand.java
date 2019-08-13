package me.ryder.savagecore.commands;

import me.ryder.savagecore.SavageCore;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractCommand implements Executable {
    private String label;
    public Set<String> alias;

    public AbstractCommand(SavageCore plugin, String label, boolean playerRequired) {
        this.alias = new HashSet();
        this.args = new ArrayList();
        this.label = label;
        this.playerRequired = playerRequired;
        this.plugin = plugin;
    }

    public ArrayList<String> args; private boolean playerRequired; private SavageCore plugin;

    public String getLabel() { return this.label; }

    public boolean isPlayerRequired() { return this.playerRequired; }

    public SavageCore getPlugin() { return this.plugin; }
}