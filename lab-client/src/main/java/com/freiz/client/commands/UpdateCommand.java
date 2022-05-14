package com.freiz.client.commands;

import com.freiz.client.commands.subcommand.AddElem;
import com.freiz.client.utility.OutputManager;
import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.UserInputManager;
import com.freiz.client.utility.CommandResult;
import com.freiz.client.data.SpaceMarine;

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
        Long id;
        try {
            id = Long.parseLong(arg);
        } catch (NumberFormatException e) {
            return new CommandResult(false, "Your argument was incorrect. The command was not executed.");
        }
        if (!collectionManager.isHaveId(id)) {
            return new CommandResult(false, "have not this id");
        }
        SpaceMarine spaceMarine;
        spaceMarine = AddElem.add(false, userInputManager, outputManager, collectionManager);
        spaceMarine.setId(id);
        collectionManager.removeByID(id);
        collectionManager.add(spaceMarine);
        return new CommandResult(false, "success added");

    }
}
