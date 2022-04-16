package data;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private final double x;
    private final float y;

    public Coordinates(double x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }
}
