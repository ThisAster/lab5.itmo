package com.freiz.client.commands;

import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.CommandResult;

public class CountGreaterThanHeartCountCommand extends Command {

    private final CollectionManager collectionManager;

    public CountGreaterThanHeartCountCommand(CollectionManager collectionManager) {
        super("count_greater_than_heart_count");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        try {
            return new CommandResult(false, collectionManager.filterGreaterThanHeartCount(Integer.parseInt(arg)).toString());
        } catch (NumberFormatException e) {
            return new CommandResult(false, e.getMessage());
        }
    }
}
