package data;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class SpaceMarine implements Comparable<SpaceMarine>, Serializable {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate = ZonedDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float health; //Значение поля должно быть больше 0
    private int heartCount; //Значение поля должно быть больше 0, Максимальное значение поля: 3
    private Weapon weaponType; //Поле не может быть null
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine(String name, Coordinates coordinates, float health, int heartCount, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
        this.heartCount = heartCount;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }
    public Weapon getWeaponType() {
        return weaponType;
    }

    public int getHeartCount() {
        return heartCount;
    }

    @Override
    public int compareTo(SpaceMarine o) {
        return Integer.compare(heartCount, o.heartCount);
    }

    @Override
    public String toString() {
        return "SpaceMarine{"
                + "id='" + id + '\''
                + ", name=" + name
                + ", coordinates=" + coordinates
                + ", creationDate=" + creationDate
                + ", health=" + health
                + ", heartCount=" + heartCount
                + ", weaponType=" + weaponType
                + ", chapter=" + chapter + "\n";
    }
}




