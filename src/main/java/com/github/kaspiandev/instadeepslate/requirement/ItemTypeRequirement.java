package com.github.kaspiandev.instadeepslate.requirement;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class ItemTypeRequirement extends Requirement {

    private static final String MATERIAL_KEY = "material";

    private final Material material;

    public ItemTypeRequirement(Map<String, Object> data) {
        super(RequirementType.ITEM_TYPE);
        this.material = Material.valueOf((String) data.get(MATERIAL_KEY));
    }

    public ItemTypeRequirement(Material material) {
        super(RequirementType.ITEM_TYPE);
        this.material = material;
    }

    @Override
    public boolean check(Player player, ItemStack item) {
        return item.getType().equals(material);
    }

    @Override
    protected Map<String, Object> toMap() {
        return Map.of(
                MATERIAL_KEY, material.name()
        );
    }

}
