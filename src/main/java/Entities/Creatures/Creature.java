package Entities.Creatures;

import Entities.Entity;
import World.Coordinates;
import World.CoordinatesShift;
import World.World;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Creature extends Entity implements ICreature {

    protected int speed;
    protected int health;

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    public Coordinates makeMove(World world) {

        Set<Coordinates> availableCoordinates = getAvailableCoordinateForMove(world);

        if (!availableCoordinates.isEmpty()) {
            coordinates = selectMoveCoordinate(availableCoordinates);
            return selectMoveCoordinate(availableCoordinates);
        }

        return coordinates;
    }

    public Set<Coordinates> getAvailableCoordinateForMove(World world) {

        Set<Coordinates> availableCoordinates = new HashSet<Coordinates>();

        for (CoordinatesShift shift : getMoveCoordinates(speed)) {

            if (coordinates.canShift(shift, world)) {
                Coordinates newCoordinates = coordinates.shift(shift);

                if (isAvailableCoordinateForMove(newCoordinates, world)) {
                    availableCoordinates.add(newCoordinates);
                }
            }
        }

        return availableCoordinates;
    }

    protected abstract boolean isAvailableCoordinateForMove(Coordinates coordinates, World world);

    protected Set<CoordinatesShift> getMoveCoordinates(int speed) {

        Set<CoordinatesShift> moveCoordinates = new HashSet<>();

        for (int shift = 1; shift <= speed; shift++) {
            List<CoordinatesShift> coordinates = Arrays.asList(
                    new CoordinatesShift(shift, 0),
                    new CoordinatesShift(shift, shift),
                    new CoordinatesShift(0, shift),
                    new CoordinatesShift(-shift, shift),
                    new CoordinatesShift(-shift, 0),
                    new CoordinatesShift(-shift, -shift),
                    new CoordinatesShift(0, -shift),
                    new CoordinatesShift(shift, -shift)
            );

            moveCoordinates.addAll(coordinates);
        }

        return moveCoordinates;
    }
}
