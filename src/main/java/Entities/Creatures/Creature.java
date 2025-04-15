package Entities.Creatures;

import Entities.Entity;
import PathFinder.BFS.PathFinder;
import World.Coordinates;
import World.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class Creature extends Entity {

    protected int speed;
    protected int health;

    public Creature(Coordinates coordinates, int speed, int health) {
        super(coordinates);
        this.speed = speed;
        this.health = health;
    }

    public Coordinates makeAction(World world) {

        List<Coordinates> path = PathFinder.getPath(getCoordinates(), this, world);

        if (path.size() == 1) {
            return makeAttack(path.get(0), world);

        } else if (path.size() > 1) {

            if (isAvailableSpeedMove(path, world)) {
                return path.get(speed - 1);
            }

            return path.get(0);
        }

        return makeRandomMove(world);
    }

    private boolean isAvailableSpeedMove(List<Coordinates> path, World world) {
        return speed > 1 && isAvailableCoordinateForAction(path.get(speed - 1), world);
    }

    protected abstract Coordinates makeAttack(Coordinates targetCoordinates, World world);

    private Coordinates makeRandomMove(World world) {
        Set<Coordinates> availableCoordinates = getAvailableCoordinateForAction(world);

        if (!availableCoordinates.isEmpty()) {
            setCoordinates(getRandomCoordinateForMove(availableCoordinates));
            return getCoordinates();
        }

        return getCoordinates();
    }

    public Set<Coordinates> getAvailableCoordinateForAction(World world) {
        Set<Coordinates> availableCoordinates = new HashSet<Coordinates>();

        for (Coordinates shift : getMoveCoordinates(speed)) {
            if (canShift(shift, world)) {
                Coordinates newCoordinates = getCoordinates().shift(shift);

                if (isAvailableCoordinateForAction(newCoordinates, world)) {
                    availableCoordinates.add(newCoordinates);
                }
            }
        }

        return availableCoordinates;
    }

    private boolean canShift(Coordinates shift, World world) {

        int newX = getCoordinates().getX() + shift.getX();
        int newY = getCoordinates().getY() + shift.getY();

        if (newX < 0 || newX >= world.getWidth()) return false;
        if (newY < 0 || newY >= world.getHeight()) return false;

        return true;
    }

    protected boolean isAvailableCoordinateForAction(Coordinates coordinates, World world) {
        return world.isWorldCellEmpty(coordinates);
    }

    protected Set<Coordinates> getMoveCoordinates(int speed) {

        Set<Coordinates> moveCoordinates = new HashSet<>();

        for (int shift = 1; shift <= speed; shift++) {
            List<Coordinates> coordinates = Arrays.asList(
                    new Coordinates(shift, 0),
                    new Coordinates(shift, shift),
                    new Coordinates(0, shift),
                    new Coordinates(-shift, shift),
                    new Coordinates(-shift, 0),
                    new Coordinates(-shift, -shift),
                    new Coordinates(0, -shift),
                    new Coordinates(shift, -shift)
            );

            moveCoordinates.addAll(coordinates);
        }

        return moveCoordinates;
    }

    public Coordinates getRandomCoordinateForMove(Set<Coordinates> availableCoordinates) {

        Random rand = new Random();
        int randomCoordinatesIndex = rand.nextInt(availableCoordinates.size());

        List<Coordinates> availableCoordinatesList = new ArrayList<>(availableCoordinates);
        Coordinates newRandomCoordinates = availableCoordinatesList.get(randomCoordinatesIndex);

        return newRandomCoordinates;
    }
}