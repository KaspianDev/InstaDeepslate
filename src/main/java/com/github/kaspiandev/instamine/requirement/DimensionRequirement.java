package com.github.kaspiandev.instamine.requirement;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class DimensionRequirement extends Requirement {

    private static final String DIMENSION_KEY = "dimension";

    private final World.Environment dimension;

    public DimensionRequirement(Map<String, Object> data) {
        super(RequirementType.WORLD);
        this.dimension = World.Environment.valueOf((String) data.get(DIMENSION_KEY));
    }

    public DimensionRequirement(World.Environment dimension) {
        super(RequirementType.WORLD);
        this.dimension = dimension;
    }

    @Override
    public boolean check(Player player, ItemStack item) {
        return player.getWorld().getEnvironment() == dimension;
    }

    @Override
    protected Map<String, Object> toMap() {
        return Map.of(
                DIMENSION_KEY, dimension.name()
        );
    }

}
