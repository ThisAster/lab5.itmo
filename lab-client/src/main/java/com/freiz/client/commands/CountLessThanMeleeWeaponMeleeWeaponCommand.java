package com.freiz.client.commands;

import com.freiz.client.utility.CommandResult;
import com.freiz.client.data.MeleeWeapon;

import java.util.StringJoiner;

public class CountLessThanMeleeWeaponMeleeWeaponCommand extends Command {
    public CountLessThanMeleeWeaponMeleeWeaponCommand() {
        super("count_less_than_melee_weapon");
    }

    @Override
    public CommandResult execute(String arg) {
        StringJoiner output = new StringJoiner("\n\n");
        try {
            MeleeWeapon inpEnum = MeleeWeapon.valueOf(arg);
            return new CommandResult(false, output.toString());
        } catch (IllegalArgumentException e) {
            return new CommandResult(false, "Your argument was incorrect");
        }
    }
}
