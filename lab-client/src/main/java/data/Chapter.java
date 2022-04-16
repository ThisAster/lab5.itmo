package data;


public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;
    private Integer marinesCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000
    private String world; //Поле может быть null

    public Chapter(String name, String parentLegion, Integer marinesCount, String world) {
        this.name = name;
        this.parentLegion = parentLegion;
        this.marinesCount = marinesCount;
        this.world = world;
    }

    @Override
    public String toString() {
        return "Chapter{"
                + "name='" + name + '\''
                + ", parentLegion=" + parentLegion
                + ", marinesCount=" + marinesCount
                + ", world=" + world
                + '}';
    }
}
