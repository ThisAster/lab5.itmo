package com.freiz.client.commands.subcommand;

import com.freiz.client.utility.CollectionManager;
import com.freiz.client.utility.OutputManager;
import com.freiz.client.utility.UserInputManager;
import com.freiz.client.data.Chapter;
import com.freiz.client.data.Coordinates;
import com.freiz.client.data.SpaceMarine;

import java.time.ZonedDateTime;

public final class AddElem {
    public static final double MINX = 0D;
    public static final float MINY = -381F;
    public static final int MINHEARTCOUNT = 0;
    public static final int MAXHEARTCOUNT = 3;
    public static final Integer MINMARINESCOUNT = 0;
    public static final Integer MAXMARINESCOUNT = 1000;
    public static final float MAXHEALTH = 0F;
    private AddElem() {
        //private construction
    }

    public static SpaceMarine add(boolean newId, UserInputManager userInputManager, OutputManager outputManager, CollectionManager collectionManager) {
        Coordinates.CoordinatesBuilder coordinatesBuilder = Coordinates.newBuilder();
        coordinatesBuilder.setX(userInputManager.readDoubleValueH(" x(coordinates)", outputManager, x -> x <= MINX));
        coordinatesBuilder.setY(userInputManager.readFloatValueWithPredicatH(" y(coordinates)", outputManager, y -> y <= MINY));

        Chapter chapter;
        Chapter.ChapterBuilder chapterBuilder = Chapter.newBuilder();
        chapterBuilder.setName(userInputManager.readStringNameValue(" name(Chapter)", outputManager));
        chapterBuilder.setParentLegion(userInputManager.readStringValue(" parentLegion(Chapter)", outputManager));
        chapterBuilder.setMarinesCount(userInputManager.readIntegerValueH(" marinesCount(Chapter)", outputManager, x -> x <= MINMARINESCOUNT || x > MAXMARINESCOUNT));
        chapterBuilder.setWorld(userInputManager.readStringValue(" world(Chapter)", outputManager));
        chapter = chapterBuilder.build();

        SpaceMarine.SpaceMarineBuilder spaceMarineBuilder = SpaceMarine.newBuilder();
        spaceMarineBuilder.setName(userInputManager.readStringNameValue(" name(SpaceMarine)", outputManager));
        spaceMarineBuilder.setChapter(chapter);
        spaceMarineBuilder.setCoordinates(coordinatesBuilder.build());
        spaceMarineBuilder.setHealth(userInputManager.readFloatValueWithPredicatH(" health(SpaceMarine)", outputManager, x -> x <= MAXHEALTH));
        spaceMarineBuilder.setHeartCount(userInputManager.readIntegerValueH(" heartCount(SpaceMarine)", outputManager, x -> x <= MINHEARTCOUNT || x > MAXHEARTCOUNT));
        spaceMarineBuilder.setWeaponType(userInputManager.readWeaponType(" HEAVY_BOLTGUN or BOLT_RIFLE or GRENADE_LAUNCHER or INFERNO_PISTOL or MULTI_MELTA", outputManager));
        spaceMarineBuilder.setMeleeWeapon(userInputManager.readMeleeWeaponType(" CHAIN_SWORD or MANREAPER or LIGHTING_CLAW or POWER_BLADE or POWER_FIST", outputManager));
        if (newId) {
            spaceMarineBuilder.id(collectionManager.getNewID());
        } else {
            spaceMarineBuilder.id(1L);
        }
        spaceMarineBuilder.creationDate(ZonedDateTime.now());
        return spaceMarineBuilder.build();
    }
}
