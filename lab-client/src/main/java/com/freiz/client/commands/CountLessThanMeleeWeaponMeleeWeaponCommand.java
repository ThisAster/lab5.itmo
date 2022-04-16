package com.freiz.client.commands;

import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.CommandResult;
import data.MeleeWeapon;

import java.util.StringJoiner;

public class CountLessThanMeleeWeaponMeleeWeaponCommand extends Command {
    private final CollectionManager collectionManager;

    public CountLessThanMeleeWeaponMeleeWeaponCommand(CollectionManager collectionManager) {
        super("count_less_than_melee_weapon");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        StringJoiner output = new StringJoiner("\n\n");
        MeleeWeapon inpEnum;
        try {
            inpEnum = MeleeWeapon.valueOf(arg);
        } catch (IllegalArgumentException e) {
            return new CommandResult(false, "Your argument was incorrect");
        }


        return new CommandResult(false, output.toString());
    }
}
