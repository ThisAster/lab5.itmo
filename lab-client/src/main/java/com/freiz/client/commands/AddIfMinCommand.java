package com.freiz.client.commands;

import com.freiz.client.utility.OutputManager;
import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.UserInputManager;
import com.freiz.client.utility.CommandResult;
import com.freiz.client.utility.SpaceMarineMaker;
import data.SpaceMarine;

public class AddIfMinCommand extends Command {
    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;

    public AddIfMinCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("add_if_min");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        SpaceMarine spaceMarine = new SpaceMarineMaker(userInputManager, outputManager).makeSpaceMarine();

        if (collectionManager.isEmpty() || collectionManager.getMinHeartCount() > spaceMarine.getHeartCount()) {
            collectionManager.add(spaceMarine);
            return new CommandResult(false, "The element was added successfully");
        } else {
            return new CommandResult(false, "The element was not min, so it was not added");
        }
    }
}

