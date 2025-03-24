package Entities.Creatures;

import Entities.Entity;
import World.Coordinates;
import World.CoordinatesShift;
import World.World;

import java.util.HashSet;
import java.util.Set;

public abstract class Creature extends Entity implements moveable {

    //Абстрактный класс, наследуется от Entities.Entity.
    //Существо, имеет скорость (сколько клеток может пройти за 1 ход), количество HP.
    protected int speed;
    protected int health;

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    public void makeMove() {
        //Имеет метод makeMove() - сделать ход.
    }

    public Set<Coordinates> getAvailableCoordinateForMove(World world) {

        Set<Coordinates> availableCoordinates = new HashSet<Coordinates>();

        for (CoordinatesShift shift : getMoveCoordinates()) {
            if (coordinates.canShift(shift, world)) {
                Coordinates newCoordinates = coordinates.shift(shift);

                if (isAvailableCoordinateForMove(newCoordinates, world)) {
                    availableCoordinates.add(newCoordinates);
                }
            }
        }

        return availableCoordinates;
    }

    private boolean isAvailableCoordinateForMove(Coordinates coordinates, World world) {
        return world.isWorldCellEmpty(coordinates);
    }

    protected abstract Set<CoordinatesShift> getMoveCoordinates();

}
