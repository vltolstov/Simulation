package Entities.Creatures;

import Entities.Entity;
import PathFinder.BFS.PathFinder;
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

    public Coordinates makeAction(World world) {

        List<Coordinates> path = PathFinder.getPath(coordinates, this, world);

        if (path.size() == 1) {
            return makeAttack(path.get(0), world);

        } else if (path.size() > 1) {

            if (speed > 1 && isAvailableCoordinateForAction(path.get(speed - 1), world)) {
                return makeMoveToTarget(path.get(speed - 1));
            } else {
                return makeMoveToTarget(path.get(0));
            }
        }

        return makeRandomMove(world);
    }

    protected abstract Coordinates makeAttack(Coordinates targetCoordinates, World world);

    private Coordinates makeMoveToTarget(Coordinates targetCoordinates) {
        return targetCoordinates;
    }

    private Coordinates makeRandomMove(World world) {
        Set<Coordinates> availableCoordinates = getAvailableCoordinateForAction(world);

        if (!availableCoordinates.isEmpty()) {
            coordinates = selectMoveCoordinate(availableCoordinates);
            return coordinates;
        }

        return coordinates;
    }

    public Set<Coordinates> getAvailableCoordinateForAction(World world) {
        Set<Coordinates> availableCoordinates = new HashSet<Coordinates>();

        for (CoordinatesShift shift : getMoveCoordinates(speed)) {
            if (coordinates.canShift(shift, world)) {
                Coordinates newCoordinates = coordinates.shift(shift);

                if (isAvailableCoordinateForAction(newCoordinates, world)) {
                    availableCoordinates.add(newCoordinates);
                }
            }
        }

        return availableCoordinates;
    }

    protected boolean isAvailableCoordinateForAction(Coordinates coordinates, World world) {
        return world.isWorldCellEmpty(coordinates);
    }

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