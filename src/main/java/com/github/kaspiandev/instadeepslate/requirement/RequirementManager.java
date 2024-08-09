package com.github.kaspiandev.instadeepslate.requirement;

import com.github.kaspiandev.instadeepslate.InstaDeepslate;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequirementManager {

    private final InstaDeepslate plugin;
    private final Map<Material, List<Requirement>> blockRequirements;

    public RequirementManager(InstaDeepslate plugin) {
        this.plugin = plugin;
        this.blockRequirements = new HashMap<>();

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

            List<Requirement> requirements = blocksSection.getMapList(blockName).stream()
                                                          .map((map) -> RequirementType.buildMatching((Map<String, Object>) map))
                                                          .toList();
            Requirement requirement = RequirementType.buildMatching();
        }
    }

}
