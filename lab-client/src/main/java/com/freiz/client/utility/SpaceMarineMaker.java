package com.freiz.client.utility;

import data.SpaceMarine;
import data.Weapon;
import data.MeleeWeapon;
import data.Coordinates;
import data.Chapter;

import java.util.function.Function;
import java.util.function.Predicate;

public class SpaceMarineMaker extends OutputManager {
    private static final int MAX_HEART_COUNT = 3;
    private static final int MAX_MARINE_COUNT = 1000;
    private static final String ERROR_MESSAGE = "Your enter was not correct type. Try again";
    private final OutputManager outputManager;
    private final Asker asker;

    public SpaceMarineMaker(UserInputManager userInputManager, OutputManager outputManager) {
        this.outputManager = outputManager;
        this.asker = new Asker(userInputManager, outputManager);
    }

    public SpaceMarine makeSpaceMarine() {
        return askForSpaceMarine();
    }

    public SpaceMarine askForSpaceMarine() {
        outputManager.println("Enter spaceMarine data");
        String name = asker.ask(arg -> (arg).length() > 0, "Enter name (String)",
                ERROR_MESSAGE, "The string must not be empty", x -> x, false);
        Float health = asker.ask(arg -> (arg) > 0, "Enter health (float) (can not be null)",
                ERROR_MESSAGE, "Your float must be >0. Try again", Float::parseFloat, false); //>0
        Integer heartCount = asker.ask(arg -> (arg) > 0 && (arg) <= MAX_HEART_COUNT, "Enter heartCount (int) (can not be null)",
                ERROR_MESSAGE, "Your int must be >0 and <=3. Try again", Integer::parseInt, false); // >0 && <=3
        MeleeWeapon meleeWeapon = asker.ask(arg -> true, "Enter meleeWeapon (CHAIN_SWORD, MANREAPER, LIGHTING_CLAW, POWER_BLADE, POWER_FIST) (can't be null)",
                ERROR_MESSAGE, ERROR_MESSAGE, MeleeWeapon::valueOf, false);
        Weapon weapon = asker.ask(arg -> true, "Enter weapon (HEAVY_BOLTGUN, BOLT_RIFLE, GRENADE_LAUNCHER,INFERNO_PISTOL, MULTI_MELTA}",
                ERROR_MESSAGE, ERROR_MESSAGE, Weapon::valueOf, false);
        Coordinates coordinates = askForCoordinates();
        Chapter chapter = askForChapter();
        return new SpaceMarine(name, coordinates, health, heartCount, weapon, meleeWeapon, chapter);
    }

    private Coordinates askForCoordinates() {
        outputManager.println("Enter coordinates data");
        final long xMin = 0;
        final double yMin = -381;
        long x = asker.ask(arg -> (arg) > xMin, "Enter x (long)",
                ERROR_MESSAGE, "The long must be >0. Try again", Long::parseLong, false); //> -896
        double y = asker.ask(arg -> (arg) > yMin, "Enter y (double)",
                ERROR_MESSAGE, "The double must be > -381. Try again", Double::parseDouble, false); //> -381, not null
        return new Coordinates((double) x, (float) y);
    }

    private Chapter askForChapter() {
        outputManager.println("Enter chapter data");
        String name = asker.ask(arg -> (arg).length() > 0, "Enter name (String)",
                ERROR_MESSAGE, "The string must not be empty", x -> x, false);
        String parentLegion = asker.ask(arg -> true, "Enter parentLegion (String)", ERROR_MESSAGE, "",x -> x, true);
        Integer marinesCount = asker.ask(arg -> (arg) > 0 && (arg) <= MAX_MARINE_COUNT, "Enter marinesCount (Integer)",
                ERROR_MESSAGE, "The Integer must be >0 && <=1000", Integer::parseInt, false);
        String world = asker.ask(arg -> true, "Enter world (String)s", ERROR_MESSAGE, "", x -> x, true);
        return new Chapter(name, parentLegion, marinesCount, world);
    }

    public static class Asker {

        private final UserInputManager userInputManager;
        private final OutputManager outputManager;


        public Asker(UserInputManager userInputManager, OutputManager outputManager) {
            this.userInputManager = userInputManager;
            this.outputManager = outputManager;
        }

        public <T> T ask(Predicate<T> predicate,
                         String askMessage,
                         String errorMessage,
                         String wrongValueMessage,
                         Function<String, T> converter,
                         boolean nullable) {
            outputManager.println(askMessage);
            String input;
            T value;
            do {
                try {
                    input = userInputManager.nextLine();
                    if ("".equals(input) && nullable) {
                        return null;
                    }

                    value = converter.apply(input);

                } catch (IllegalArgumentException e) {
                    outputManager.println(errorMessage);
                    continue;
                }
                if (predicate.test(value)) {
                    return value;
                } else {
                    outputManager.println(wrongValueMessage);
                }
            } while (true);
        }
    }
}
