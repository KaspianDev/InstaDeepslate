package com.github.kaspiandev.instamine.requirement;

import com.github.kaspiandev.instamine.InstaMine;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequirementManager {

    private final InstaMine plugin;
    private final Map<Material, List<Requirement>> blockRequirements;

    public RequirementManager(InstaMine plugin) {
        this.plugin = plugin;
        this.blockRequirements = new HashMap<>();
        load();

    }

    public void reload() {
        blockRequirements.clear();

        load();
    }

    @SuppressWarnings("unchecked")
    private void load() {
        ConfigurationSection blocksSection = plugin.getConfig().getConfigurationSection("blocks");
        if (blocksSection == null) {
            throw new IllegalStateException("'blocks' section in config doesn't exist! Reset your config.");
        }

        for (String blockName : blocksSection.getKeys(false)) {
            Material blockType = Material.valueOf(blockName);

            List<Requirement> requirements = (List<Requirement>) blocksSection.getList(blockName);
            blockRequirements.put(blockType, requirements);
        }
    }

    public List<Requirement> getRequirements(Material block) {
        return blockRequirements.getOrDefault(block, List.of());
    }

}
