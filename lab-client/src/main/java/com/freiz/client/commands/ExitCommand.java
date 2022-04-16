package com.freiz.client.commands;

import com.freiz.client.utility.CommandResult;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit");
    }

    @Override
    public CommandResult execute(String arg) {
        return new CommandResult(true, "Exiting...");
    }
}

