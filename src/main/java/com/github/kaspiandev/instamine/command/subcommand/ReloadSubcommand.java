package com.github.kaspiandev.instamine.command.subcommand;

import com.github.kaspiandev.instamine.InstaMine;
import com.github.kaspiandev.instamine.command.SubCommand;
import com.github.kaspiandev.instamine.command.SubCommands;
import com.github.kaspiandev.instamine.util.ColorUtil;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ReloadSubcommand extends SubCommand {

    private final InstaMine plugin;

    public ReloadSubcommand(InstaMine plugin) {
        super(SubCommands.RELOAD, plugin.getConfig().getString("message.no-perms"));
        this.plugin = plugin;
    }

    @Override
    protected void execute(CommandSender sender, String[] args) {
        plugin.reloadConfig();
        plugin.getRequirementManager().reload();
        sender.spigot().sendMessage(ColorUtil.component(plugin.getConfig().getString("message.reloaded")));
    }

    @Override
    public List<String> suggestions(CommandSender sender, String[] args) {
        return List.of();
    }

}
