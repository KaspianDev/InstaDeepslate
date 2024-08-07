package com.github.kaspiandev.instadeepslate;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DeepslateMineListener implements Listener {

    @EventHandler
    public void onMine(BlockDamageEvent event) {
        Block block = event.getBlock();
        if (block.getType() != Material.DEEPSLATE) return;

        Player player = event.getPlayer();
        PotionEffect effect = player.getPotionEffect(PotionEffectType.FAST_DIGGING);
        if (effect == null || effect.getAmplifier() < 1) return;

        ItemStack pickaxe = event.getItemInHand();
        if (pickaxe.getType() != Material.NETHERITE_PICKAXE) return;

        ItemMeta meta = pickaxe.getItemMeta();
        if (meta == null || meta.getEnchantLevel(Enchantment.DIG_SPEED) < 5) return;

        event.setInstaBreak(true);
    }

}
