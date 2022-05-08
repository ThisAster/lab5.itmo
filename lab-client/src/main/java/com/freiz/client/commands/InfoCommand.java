package com.freiz.client.commands;

import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.CommandResult;

public class InfoCommand extends Command {

    private final CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        super("info");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        return new CommandResult(false, "Collection type: " + collectionManager.getClass().toString() + "\n"
                + "Count elem: " + collectionManager.size() + "\n"
                + "Creation date: " + collectionManager.getCreationDate());
    }
}
