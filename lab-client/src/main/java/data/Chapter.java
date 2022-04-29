package data;


public final class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;
    private Integer marinesCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000
    private String world; //Поле может быть null

    private Chapter() {
        //private constructor
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

    public static ChapterBuilder newBuilder() {
        return new Chapter().new ChapterBuilder();
    }

    public final class ChapterBuilder {
        private ChapterBuilder() {
            //private construction
        }
        public ChapterBuilder setName(String name) {
            Chapter.this.name = name;
            return this;
        }
        public ChapterBuilder setParentLegion(String parentLegion) {
            Chapter.this.parentLegion = parentLegion;
            return this;
        }
        public ChapterBuilder setMarinesCount(Integer marinesCount) {
            Chapter.this.marinesCount = marinesCount;
            return this;
        }
        public ChapterBuilder setWorld(String world) {
            Chapter.this.world = world;
            return this;
        }
        public Chapter build() {
            return Chapter.this;
        }
    }
}
