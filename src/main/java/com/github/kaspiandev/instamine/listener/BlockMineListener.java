package com.github.kaspiandev.instamine.listener;

import com.github.kaspiandev.instamine.InstaMine;
import com.github.kaspiandev.instamine.event.BlockInstaMineEvent;
import com.github.kaspiandev.instamine.event.BlockPreInstaMineEvent;
import com.github.kaspiandev.instamine.requirement.Requirement;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class BlockMineListener implements Listener {

    private final InstaMine plugin;

    public BlockMineListener(InstaMine plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onMine(BlockDamageEvent event) {
        Block block = event.getBlock();
        List<Requirement> requirements = plugin.getRequirementManager().getRequirements(block.getType());
        if (requirements.isEmpty()) return;

        Player player = event.getPlayer();
        ItemStack item = event.getItemInHand();
        if (requirements.stream().anyMatch((requirement) -> !requirement.check(player, item))) return;

        BlockPreInstaMineEvent instaMineEvent = new BlockPreInstaMineEvent(block, player, item);
        Bukkit.getPluginManager().callEvent(instaMineEvent);
        if (instaMineEvent.isCancelled()) return;

        event.setInstaBreak(true);
        block.getWorld().playSound(block.getLocation(), block.getBlockData().getSoundGroup().getBreakSound(), 1, 1);
        Bukkit.getPluginManager().callEvent(new BlockInstaMineEvent(block, player, item));
    }

}
