package com.github.kaspiandev.instadeepslate.requirement;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Requirement implements ConfigurationSerializable {

    protected final RequirementType type;

    protected Requirement(RequirementType type) {
        this.type = type;
    }

    public RequirementType getType() {
        return type;
    }

    public abstract boolean check(Player player, ItemStack item);

    protected abstract Map<String, Object> toMap();

    @Override
    public final Map<String, Object> serialize() {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("type", type.name());
        data.putAll(toMap());
        return data;
    }

}
