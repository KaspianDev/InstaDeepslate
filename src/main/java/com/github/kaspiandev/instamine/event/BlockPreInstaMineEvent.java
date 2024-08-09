package com.github.kaspiandev.instamine.event;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPreInstaMineEvent extends BlockBreakEvent implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ItemStack usedItem;
    private boolean cancelled;

    public BlockPreInstaMineEvent(Block block, Player player, ItemStack usedItem) {
        super(block, player);
        this.usedItem = usedItem;
        this.cancelled = false;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public ItemStack getItem() {
        return usedItem;
    }

}
