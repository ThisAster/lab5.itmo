package com.freiz.client.commands;


import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.CommandResult;

public class RemoveByIdCommand extends Command {
    private final CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager) {
        super("remove_by_id");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Long id;
        try {
            id = Long.parseLong(arg);
        } catch (NumberFormatException e) {
            return new CommandResult(false, "Your argument was incorrect. The command was not executed.");
        }
        if (collectionManager.removeByID(id)) {
            return new CommandResult(false, "remove success");
        }
        return new CommandResult(false, "not SpaceMarine with id");
    }
}
