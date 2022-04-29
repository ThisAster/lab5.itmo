package data;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class SpaceMarine implements Comparable<SpaceMarine>, Serializable {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float health; //Значение поля должно быть больше 0
    private int heartCount; //Значение поля должно быть больше 0, Максимальное значение поля: 3
    private Weapon weaponType; //Поле не может быть null
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле не может быть null

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

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(SpaceMarine o) {
        Integer oValue = o.getHeartCount();
        Integer thisValue = this.getHeartCount();
        Integer oLengthName = o.getName().length();
        Integer thisLengthName = this.getName().length();
        if (oValue - thisValue != 0) {
            return thisValue - oValue;
        } else if (oLengthName - thisLengthName != 0) {
            return thisLengthName - oLengthName;
        } else {
            return Float.compare(health, o.health);
        }
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

    public static SpaceMarineBuilder newBuilder() {
        return new SpaceMarine().new SpaceMarineBuilder();
    }

    public final class SpaceMarineBuilder {
        public SpaceMarineBuilder id(Long sameId) {
            SpaceMarine.this.id = sameId;
            return this;
        }
        public SpaceMarineBuilder setName(String name) {
            SpaceMarine.this.name = name;
            return this;
        }
        public SpaceMarineBuilder setCoordinates(Coordinates coordinates) {
            SpaceMarine.this.coordinates = coordinates;
            return this;
        }
        public SpaceMarineBuilder setHealth(Float health) {
            SpaceMarine.this.health = health;
            return this;
        }
        public SpaceMarineBuilder setHeartCount(int heartCount) {
            SpaceMarine.this.heartCount = heartCount;
            return this;
        }
        public SpaceMarineBuilder setWeaponType(Weapon weaponType) {
            SpaceMarine.this.weaponType = weaponType;
            return this;
        }
        public SpaceMarineBuilder setMeleeWeapon(MeleeWeapon meleeWeapon) {
            SpaceMarine.this.meleeWeapon = meleeWeapon;
            return this;
        }
        public SpaceMarineBuilder setChapter(Chapter chapter) {
            SpaceMarine.this.chapter = chapter;
            return this;
        }
        public SpaceMarineBuilder creationDate(ZonedDateTime sameCreationDate) {
            SpaceMarine.this.creationDate = sameCreationDate;
            return this;
        }
        public SpaceMarine build() {
            return SpaceMarine.this;
        }
    }
}
