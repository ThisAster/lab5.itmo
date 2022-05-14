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
        coordinatesBuilder.setX(userInputManager.readDoubleValueH(" x(coordinates)", outputManager, x -> x <= MINX, "Значение поля должно быть больше 0"));
        coordinatesBuilder.setY(userInputManager.readFloatValueWithPredicatH(" y(coordinates)", outputManager, y -> y <= MINY, "Значение поля должно быть больше -381"));

        Chapter chapter;
        Chapter.ChapterBuilder chapterBuilder = Chapter.newBuilder();
        chapterBuilder.setName(userInputManager.readStringNameValue(" name(Chapter, dataFormat: String)", outputManager, "Поле не может быть null, Строка не может быть пустой"));
        chapterBuilder.setParentLegion(userInputManager.readStringValue(" parentLegion(Chapter, dataFormat: String)", outputManager));
        chapterBuilder.setMarinesCount(userInputManager.readIntegerValueH(" marinesCount(Chapter, dataFormat: Integer)", outputManager, x -> x <= MINMARINESCOUNT || x > MAXMARINESCOUNT, "Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000 or Check dataFormat please"));
        chapterBuilder.setWorld(userInputManager.readStringValue(" world(Chapter, dataFormat: String)", outputManager));
        chapter = chapterBuilder.build();

        SpaceMarine.SpaceMarineBuilder spaceMarineBuilder = SpaceMarine.newBuilder();
        spaceMarineBuilder.setName(userInputManager.readStringNameValue(" name(SpaceMarine, dataFormat: String)", outputManager, "Поле не может быть null, Строка не может быть пустой"));
        spaceMarineBuilder.setChapter(chapter);
        spaceMarineBuilder.setCoordinates(coordinatesBuilder.build());
        spaceMarineBuilder.setHealth(userInputManager.readFloatValueWithPredicatH(" health(SpaceMarine, dataFormat: float)", outputManager, x -> x <= MAXHEALTH, "Значение поля должно быть больше 0"));
        spaceMarineBuilder.setHeartCount(userInputManager.readIntegerValueHeartCount(" heartCount(SpaceMarine, dataFormat: int)", outputManager, x -> x <= MINHEARTCOUNT || x > MAXHEARTCOUNT, "Значение поля должно быть больше 0, Максимальное значение поля: 3 or Check dataFormat please"));
        spaceMarineBuilder.setWeaponType(userInputManager.readWeaponType(" HEAVY_BOLTGUN or BOLT_RIFLE or GRENADE_LAUNCHER or INFERNO_PISTOL or MULTI_MELTA(dataFormat: Weapon)", outputManager, "Поле не может быть null or Check dataFormat please"));
        spaceMarineBuilder.setMeleeWeapon(userInputManager.readMeleeWeaponType(" CHAIN_SWORD or MANREAPER or LIGHTING_CLAW or POWER_BLADE or POWER_FIST(dataFormat: MeleeWeapon)", outputManager, "Поле не может быть null or Check dataFormat please"));
        if (newId) {
            spaceMarineBuilder.id(collectionManager.getNewID());
        } else {
            spaceMarineBuilder.id(1L);
        }
        spaceMarineBuilder.creationDate(ZonedDateTime.now());
        return spaceMarineBuilder.build();
    }
}

