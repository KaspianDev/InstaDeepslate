package com.github.kaspiandev.instamine.requirement;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class ModelDataRequirement extends Requirement {

    private static final String MODEL_KEY = "model";

    private final int modelData;

    public ModelDataRequirement(Map<String, Object> data) {
        super(RequirementType.MODEL);
        this.modelData = (int) data.get(MODEL_KEY);
    }

    public ModelDataRequirement(int modelData) {
        super(RequirementType.MODEL);
        this.modelData = modelData;
    }

    @Override
    public boolean check(Player player, ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return false;

        return meta.getCustomModelData() == modelData;
    }

    @Override
    protected Map<String, Object> toMap() {
        return Map.of(
                MODEL_KEY, modelData
        );
    }

}
