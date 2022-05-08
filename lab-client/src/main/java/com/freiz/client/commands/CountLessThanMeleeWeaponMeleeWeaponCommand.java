package com.freiz.client.commands;

import com.freiz.client.data.MeleeWeapon;
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
        MeleeWeapon inpEnum;
        try {
            inpEnum = MeleeWeapon.valueOf(arg);
        } catch (IllegalArgumentException e) {
            return new CommandResult(false, "Your argument was incorrect");
        }
        String output = String.valueOf(collectionManager.countLessThanMeleeWeapon(inpEnum));
        return new CommandResult(false, output);
    }
}
