package com.github.kaspiandev.instamine.event;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockInstaMineEvent extends BlockBreakEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ItemStack usedItem;

    public BlockInstaMineEvent(Block block, Player player, ItemStack usedItem) {
        super(block, player);
        this.usedItem = usedItem;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public ItemStack getItem() {
        return usedItem;
    }

}
