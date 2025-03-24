package World;

import java.util.Objects;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(x + shift.xShift, y + shift.yShift);
    }

    public boolean canShift(CoordinatesShift shift, World world) {

        int newCoordinateX = x + shift.xShift;
        int newCoordinateY = y + shift.yShift;

        if(newCoordinateX < 0 || newCoordinateX > world.getWidth()) return false;
        if(newCoordinateY < 0 || newCoordinateY > world.getHeight()) return false;

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
