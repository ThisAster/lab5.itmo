package com.freiz.client.utility;

import com.freiz.client.data.MeleeWeapon;
import com.freiz.client.data.Weapon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * This class is used for all the user input: keyboard and script execution
 */
public class UserInputManager implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);
    private final Stack<BufferedReader> currentFilesReaders = new Stack<>();
    private final Stack<File> currentFiles = new Stack<>();


    public String nextLine() {
        if (!currentFilesReaders.isEmpty()) {
            try {
                String input = currentFilesReaders.peek().readLine();
                if (input == null) {
                    currentFiles.pop();
                    currentFilesReaders.pop().close();
                    return nextLine();
                } else {
                    return input;
                }


            } catch (IOException e) {
                // never throws exception
                e.printStackTrace();
            }

        } else {
            return scanner.nextLine();
        }

        // never returns ""
        return "";
    }

    public String readStringValue(String message, OutputManager outputManager) {
        boolean shouldContinue = true;
        String parentLegion = null;
        while (shouldContinue) {
            outputManager.println("enter" + message + ":");
            parentLegion = nextLine();
            shouldContinue = false;

        }
        return parentLegion;
    }

    public Integer readIntegerValueH(String message, OutputManager outputManager, Predicate<Integer> integerPredicate, String messString) {
        boolean shouldContinue = true;
        Integer integerResult = null;
        final Integer maxCond = 1000;
        final Integer minCond = 0;
        while (shouldContinue) {
            outputManager.println("enter" + message + ":");
            try {
                String line = nextLine();

                integerResult = "".equals(line) ? null : Integer.parseInt(line);
                if (integerResult == null || integerResult <= minCond || integerResult > maxCond) {
                    System.out.println(messString);
                    shouldContinue = true;
                } else {
                    shouldContinue = integerPredicate.test(integerResult);
                }
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println(messString);
                shouldContinue = true; //codestyle
            }

        }
        return integerResult;
    }

    public Integer readIntegerValueHeartCount(String message, OutputManager outputManager, Predicate<Integer> integerPredicate, String messString) {
        boolean shouldContinue = true;
        Integer integerResult = null;
        final Integer maxCond = 3;
        final Integer minCond = 0;
        while (shouldContinue) {
            outputManager.println("enter" + message + ":");
            try {
                String line = nextLine();

                integerResult = "".equals(line) ? null : Integer.parseInt(line);
                if (integerResult == null || integerResult <= minCond || integerResult > maxCond) {
                    System.out.println(messString);
                    shouldContinue = true;
                } else {
                    shouldContinue = integerPredicate.test(integerResult);
                }
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println(messString);
                shouldContinue = true; //codestyle
            }

        }
        return integerResult;
    }

    public Double readDoubleValueH(String message, OutputManager outputManager, Predicate<Double> integerPredicate, String messString) {
        boolean shouldContinue = true;
        Double doubleResult = null;
        while (shouldContinue) {
            outputManager.println(messString + "\n" + "enter" + message + ":");
            try {
                String line = nextLine();

                doubleResult = "".equals(line) ? null : Double.parseDouble(line);
                if (doubleResult != null) {
                    shouldContinue = integerPredicate.test(doubleResult);
                } else {
                    shouldContinue = true;
                }
            } catch (NumberFormatException | NullPointerException e) {
                shouldContinue = true; // codestyle`
            }

        }
        return doubleResult;
    }

    public Float readFloatValueWithPredicatH(String message, OutputManager outputManager, Predicate<Float> floatPredicate, String messString) {
        boolean shouldContinue = true;
        Float floatResult = null;
        while (shouldContinue) {
            outputManager.println(messString + "\n" + "enter" + message + ":");
            try {
                String line = nextLine();

                floatResult = "".equals(line) ? null : Float.parseFloat(line);
                if (floatResult != null) {
                    shouldContinue = floatPredicate.test(floatResult);
                } else {
                    shouldContinue = true;
                }
            } catch (NumberFormatException | NullPointerException e) {
                shouldContinue = true; // codestyle`
            }

        }
        return floatResult;
    }
    public Weapon readWeaponType(String message, OutputManager outputManager, String messString) {
        boolean shouldContinue = true;
        Weapon weaponResult = null;
        while (shouldContinue) {
            outputManager.println("enter" + message + ":");
            try {
                String line = nextLine().toUpperCase(Locale.ROOT).trim();
                if (!("".equals(line))) {
                    weaponResult = Weapon.valueOf(line);
                    shouldContinue = false;
                } else {
                    System.out.println(messString);
                    shouldContinue = true;
                }
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(messString);
                shouldContinue = true; // codestyle`
            }
        }
        return weaponResult;
    }

    public MeleeWeapon readMeleeWeaponType(String message, OutputManager outputManager, String messString) {
        boolean shouldContinue = true;
        MeleeWeapon meleeWeaponResult = null;
        while (shouldContinue) {
            outputManager.println("enter" + message + ":");
            try {
                String line = nextLine().toUpperCase(Locale.ROOT).trim();
                if (!("").equals(line)) {
                    meleeWeaponResult = MeleeWeapon.valueOf(line);
                    shouldContinue = false;
                } else {
                    System.out.println(messString);
                    shouldContinue = true;
                }
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(messString);
                shouldContinue = true; // codestyle`
            }
        }
        return meleeWeaponResult;
    }
    public String readStringNameValue(String message, OutputManager outputManager, String messString) {
        boolean shouldContinue = true;
        String name = null;
        while (shouldContinue) {
            outputManager.println("enter" + message + ":");
            name = nextLine().trim();
            if (name.length() == 0) {
                if ("".equals(name)) {
                    System.out.println(messString);
                    shouldContinue = true;
                }
            } else {
                shouldContinue = false;
            }
        }
        return name;
    }

    public void connectToFile(File file) throws IOException, UnsupportedOperationException {
        if (currentFiles.contains(file)) {
            throw new UnsupportedOperationException("The file was not executed due to recursion");
        } else {
            BufferedReader newReader = new BufferedReader(new FileReader(file));
            currentFiles.push(file);
            currentFilesReaders.push(newReader);
        }
    }

    @Override
    public void close() throws Exception {
        for (BufferedReader bufferedReader:currentFilesReaders) {
            bufferedReader.close();
        }
        scanner.close();
    }
}

