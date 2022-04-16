package com.freiz.client.commands;

import com.freiz.client.utility.OutputManager;
import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.UserInputManager;
import com.freiz.client.utility.CommandResult;
import com.freiz.client.utility.SpaceMarineMaker;
import data.SpaceMarine;

public class UpdateCommand extends Command {

    private final OutputManager outputManager;
    private final UserInputManager userInputManager;
    private final CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("update");
        this.userInputManager = userInputManager;
        this.collectionManager = collectionManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Long longArg;
        try {
            longArg = Long.parseLong(arg);
        } catch (NumberFormatException e) {
            return new CommandResult(false, "Your argument was incorrect. The command was not executed.");
        }

        if (collectionManager.removeIf(longArg)) {
            SpaceMarine spaceMarine = new SpaceMarineMaker(userInputManager, outputManager).makeSpaceMarine();
            spaceMarine.setId(longArg);
            collectionManager.update(spaceMarine);
            return new CommandResult(false, "The element was updated succesfully");
        } else {
            return new CommandResult(false, "Written id was not found. The command was not executed");
        }
    }
}
