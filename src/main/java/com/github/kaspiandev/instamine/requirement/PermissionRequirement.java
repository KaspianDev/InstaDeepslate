package com.github.kaspiandev.instamine.requirement;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class PermissionRequirement extends Requirement {

    private static final String PERMISSION_KEY = "permission";

    private final String permission;

    public PermissionRequirement(Map<String, Object> data) {
        super(RequirementType.PERMISSION);
        this.permission = (String) data.get(PERMISSION_KEY);
    }

    public PermissionRequirement(String permission) {
        super(RequirementType.PERMISSION);
        this.permission = permission;
    }

    @Override
    public boolean check(Player player, ItemStack item) {
        return player.hasPermission(PERMISSION_KEY);
    }

    @Override
    protected Map<String, Object> toMap() {
        return Map.of(
                PERMISSION_KEY, permission
        );
    }

}
