package com.freiz.client.commands;

import com.freiz.client.utility.CommandResult;

public abstract class Command {

    private final String name;

    protected Command(String name) {
        this.name = name;
    }
    public abstract CommandResult execute(String arg);
    public String getName() {
        return name;
    }
}
