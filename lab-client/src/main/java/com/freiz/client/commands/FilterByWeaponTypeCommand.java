package com.freiz.client.commands;

import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.CommandResult;
import com.freiz.client.data.Weapon;

public class FilterByWeaponTypeCommand extends Command {
    private final CollectionManager collectionManager;

    public FilterByWeaponTypeCommand(CollectionManager collectionManager) {
        super("filter_by_weapon_type");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Weapon inpEnum;
        try {
            inpEnum = Weapon.valueOf(arg);
        } catch (IllegalArgumentException e) {
            return new CommandResult(false, "Your argument was incorrect");
        }
        String output = String.valueOf(collectionManager.filterByWeaponType(inpEnum));
        return new CommandResult(false, output);
    }
}
