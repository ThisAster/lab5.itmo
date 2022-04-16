package com.freiz.client.utility;

public class CommandResult {
    private final String output;
    private final boolean exit;

    public CommandResult(boolean exit, String output) {
        this.exit = exit;
        this.output = output;
    }

    public boolean isExit() {
        return exit;
    }

    public String getOutput() {
        return output;
    }
}

