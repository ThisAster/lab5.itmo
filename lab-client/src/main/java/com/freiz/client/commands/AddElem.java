package com.freiz.client.commands;

import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.OutputManager;
import com.freiz.client.utility.SpaceMarineMaker;
import com.freiz.client.utility.UserInputManager;
import com.freiz.client.utility.CommandResult;
import data.SpaceMarine;

public final class AddElem extends Command {
    private final UserInputManager userInputManager;
    private final OutputManager outputManager;
    private final CollectionManager collectionManager;

    public AddElem(UserInputManager userInputManager, OutputManager outputManager, CollectionManager collectionManager) {
        super("add");
        this.userInputManager = userInputManager;
        this.outputManager = outputManager;
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        SpaceMarine spaceMarine = new SpaceMarineMaker(userInputManager, outputManager).makeSpaceMarine();
        collectionManager.add(spaceMarine);
        return new CommandResult(false, "The element was added successfully");
    }
}

