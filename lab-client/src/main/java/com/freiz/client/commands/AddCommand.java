package com.freiz.client.commands;

import com.freiz.client.commands.subcommand.AddElem;
import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.CommandResult;
import com.freiz.client.utility.OutputManager;
import com.freiz.client.utility.UserInputManager;
import com.freiz.client.data.SpaceMarine;

public class AddCommand extends Command {
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;
    private final OutputManager outputManager;

    public AddCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("add");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        SpaceMarine spaceMarine;
        spaceMarine = AddElem.add(true, userInputManager, outputManager, collectionManager);
        collectionManager.add(spaceMarine);
        return new CommandResult(false, "succes added");
    }
}
