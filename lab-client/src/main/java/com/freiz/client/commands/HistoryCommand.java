package com.freiz.client.commands;

import com.freiz.client.utility.CommandResult;
import com.freiz.client.utility.HistoryManager;

public class HistoryCommand extends Command {
    private final HistoryManager historyManager;

    public HistoryCommand(HistoryManager historyManager) {
        super("history");
        this.historyManager = historyManager;
    }

    @Override
    public CommandResult execute(String arg) {
        return new CommandResult(false, historyManager.niceToString());
    }
}
