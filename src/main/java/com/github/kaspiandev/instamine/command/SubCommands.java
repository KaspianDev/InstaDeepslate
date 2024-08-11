package com.github.kaspiandev.instamine.command;

public enum SubCommands {

    RELOAD("reload", "instamine.command.reload");

    private final String key;
    private final String permission;

    SubCommands(String key, String permission) {
        this.key = key;
        this.permission = permission;
    }

    public String getKey() {
        return key;
    }

    public String getPermission() {
        return permission;
    }

}
