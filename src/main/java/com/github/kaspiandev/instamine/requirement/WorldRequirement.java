package com.github.kaspiandev.instamine.requirement;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class WorldRequirement extends Requirement {

    private static final String WORLD_KEY = "world";

    private final String worldName;

    public WorldRequirement(Map<String, Object> data) {
        super(RequirementType.WORLD);
        this.worldName = (String) data.get(WORLD_KEY);
    }

    public WorldRequirement(String worldName) {
        super(RequirementType.WORLD);
        this.worldName = worldName;
    }

    @Override
    public boolean check(Player player, ItemStack item) {
        return player.getWorld().getName().equals(worldName);
    }

    @Override
    protected Map<String, Object> toMap() {
        return Map.of(
                WORLD_KEY, worldName
        );
    }

}
