package com.freiz.client.commands;

import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.CommandResult;
import data.Weapon;

import java.util.StringJoiner;

public class FilterByWeaponTypeCommand extends Command {
    private final CollectionManager collectionManager;

    public FilterByWeaponTypeCommand(CollectionManager collectionManager) {
        super("filter_by_weapon_type");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        StringJoiner output = new StringJoiner("\n\n");
        Weapon inpEnum;
        try {
            inpEnum = Weapon.valueOf(arg);
        } catch (IllegalArgumentException e) {
            return new CommandResult(false, "Your argument was incorrect");
        }

        collectionManager.filterByWeaponType(inpEnum, output);

        return new CommandResult(false, output.toString());
    }
}
