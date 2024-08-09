package com.github.kaspiandev.instadeepslate.listener;

import com.github.kaspiandev.instadeepslate.InstaDeepslate;
import com.github.kaspiandev.instadeepslate.requirement.Requirement;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class BlockMineListener implements Listener {

    private final InstaDeepslate plugin;

    public BlockMineListener(InstaDeepslate plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMine(BlockDamageEvent event) {
        System.out.println("a");
        Block block = event.getBlock();
        List<Requirement> requirements = plugin.getRequirementManager().getRequirements(block.getType());
        System.out.println(requirements);
        if (requirements.isEmpty()) return;

        Player player = event.getPlayer();
        ItemStack item = event.getItemInHand();
        if (requirements.stream().anyMatch((requirement) -> !requirement.check(player, item))) return;

        event.setInstaBreak(true);
    }

}
