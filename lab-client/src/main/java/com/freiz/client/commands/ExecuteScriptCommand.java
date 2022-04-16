package com.freiz.client.commands;

import com.freiz.client.utility.CommandResult;
import com.freiz.client.utility.UserInputManager;

import java.io.File;
import java.io.IOException;

public class ExecuteScriptCommand extends Command {

    private final UserInputManager userInputManager;

    public ExecuteScriptCommand(UserInputManager userInputManager) {
        super("execute_script");
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        try {
            userInputManager.connectToFile(new File(arg));
            return new CommandResult(false, "Starting to execute script...");
        } catch (IOException e) {
            return new CommandResult(false, "There was a problem opening the file. Check if it is available and you have written it in the command arg correctly.");
        } catch (UnsupportedOperationException e) {
            return new CommandResult(false, e.getMessage());
        }
    }
}
