package com.github.kaspiandev.instadeepslate;

import com.github.kaspiandev.instadeepslate.listener.BlockMineListener;
import com.github.kaspiandev.instadeepslate.requirement.EffectRequirement;
import com.github.kaspiandev.instadeepslate.requirement.EnchantmentRequirement;
import com.github.kaspiandev.instadeepslate.requirement.ItemTypeRequirement;
import com.github.kaspiandev.instadeepslate.requirement.RequirementManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public final class InstaDeepslate extends JavaPlugin {

    private RequirementManager requirementManager;

    @Override
    public void onEnable() {
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
    }

    public RequirementManager getRequirementManager() {
        return requirementManager;
    }

}
