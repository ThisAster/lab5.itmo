package com.freiz.client.commands;

import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.CommandResult;

public class ShowCommand extends Command {
    private final CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        return new CommandResult(false, collectionManager.toString());
    }
}

