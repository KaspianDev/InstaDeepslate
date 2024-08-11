package com.github.kaspiandev.instamine;

import com.github.kaspiandev.instamine.command.MainCommand;
import com.github.kaspiandev.instamine.command.SubCommandRegistry;
import com.github.kaspiandev.instamine.listener.BlockMineListener;
import com.github.kaspiandev.instamine.requirement.*;
import org.bukkit.Material;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;

public final class InstaMine extends JavaPlugin {

    private RequirementManager requirementManager;

    @Override
    public void onEnable() {
        Arrays.stream(RequirementType.values())
              .map(RequirementType::getRequirementClass)
              .forEach(ConfigurationSerialization::registerClass);

        getConfig().options().copyDefaults(true);
        getConfig().addDefault(
                "blocks." + Material.DEEPSLATE.name(),
                List.of(
                        new ItemTypeRequirement(Material.NETHERITE_PICKAXE),
                        new EnchantmentRequirement(Enchantment.DIG_SPEED, 5),
                        new EffectRequirement(PotionEffectType.FAST_DIGGING, 1)
                )
        );

        saveConfig();

        requirementManager = new RequirementManager(this);

        getServer().getPluginManager().registerEvents(new BlockMineListener(this), this);

        PluginCommand pluginCommand = getCommand("instamine");
        if (pluginCommand != null) {
            SubCommandRegistry subCommandRegistry = new SubCommandRegistry(this);
            MainCommand mainCommand = new MainCommand(this, subCommandRegistry);

            pluginCommand.setTabCompleter(mainCommand);
            pluginCommand.setExecutor(mainCommand);
        }
    }

    public RequirementManager getRequirementManager() {
        return requirementManager;
    }

}
