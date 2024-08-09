package com.github.kaspiandev.instadeepslate.requirement;

import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class EnchantmentRequirement extends Requirement {

    private static final String ENCHANTMENT_KEY = "enchantment";
    private static final String LEVEL_KEY = "level";

    private final Enchantment enchantment;
    private final int level;

    public EnchantmentRequirement(Map<String, Object> data) {
        super(RequirementType.ENCHANTMENT);
        this.enchantment = Registry.ENCHANTMENT.get(NamespacedKey.minecraft((String) data.get(ENCHANTMENT_KEY)));
        this.level = (int) data.get(LEVEL_KEY);
    }

    public EnchantmentRequirement(Enchantment enchantment, int level) {
        super(RequirementType.ENCHANTMENT);
        this.enchantment = enchantment;
        this.level = level;
    }

    @Override
    public boolean check(Player player, ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return false;

        System.out.println(meta.getEnchantLevel(enchantment));
        System.out.println(meta.getEnchantLevel(enchantment) >= level);
        return meta.getEnchantLevel(enchantment) >= level;
    }

    @Override
    protected Map<String, Object> toMap() {
        return Map.of(
                ENCHANTMENT_KEY, enchantment.getKey().getKey(),
                LEVEL_KEY, level
        );
    }

}
