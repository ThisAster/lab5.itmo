package com.freiz.client.commands;

import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.CommandResult;
public class CountLessThanMeleeWeaponMeleeWeaponCommand extends Command {

    public final CollectionManager collectionManager;

    public CountLessThanMeleeWeaponMeleeWeaponCommand(CollectionManager collectionManager) {
        super("count_less_than_melee_weapon");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        try {
            return new CommandResult(false, collectionManager.toString());
        } catch (NumberFormatException e) {
            return new CommandResult(false, "Your argument was incorrect");
        }
    }
}
