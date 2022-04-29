package com.freiz.client.commands;

import com.freiz.client.exception.NotMinException;
import com.freiz.client.utility.OutputManager;
import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.UserInputManager;
import com.freiz.client.utility.CommandResult;
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
        SpaceMarine spaceMarine;
        try {
            spaceMarine = AddElem.add(true, userInputManager, outputManager, collectionManager);
            collectionManager.addMin(spaceMarine);
            return new CommandResult(false, "succes added");
        } catch (NotMinException e) {
            return new CommandResult(false, "not success:" + e.getMessage());
        }
    }
}

