package Entities.Creatures;

import Entities.StaticEntities.Grass;
import World.Coordinates;
import World.World;

import java.util.Set;

public class Predator extends Creature {

    private static final String SPRITE = " \uD83D\uDC2F ";
    private final int attackPower;
    private boolean onGrass;

    public Predator(Coordinates coordinates) {
        super(coordinates);
        speed = 2;
        health = 100;
        attackPower = 20;
        onGrass = false;
    }

    @Override
    public Coordinates makeAction(World world) {

        Set<Coordinates> coordinatesForAction = getAvailableCoordinateForAction(world);

        if (isPredatorHasTarget(world, coordinatesForAction)) {
            Creature target = (Creature) world.getEntity(getTarget(world, coordinatesForAction));
            return makeAttack(target);
        }

        return makeMove(coordinatesForAction);
    }

    public Coordinates makeAttack(Creature creature) {
        if (creature.health <= attackPower) {
            return creature.coordinates;
        } else {
            creature.health = creature.health - attackPower;
            return this.coordinates;
        }
    }

    private boolean isPredatorHasTarget(World world, Set<Coordinates> coordinatesForAction) {
        for (Coordinates coordinates : coordinatesForAction) {
            if (world.getEntity(coordinates) instanceof Herbivore) {
                return true;
            }
        }
        return false;
    }

    private Coordinates getTarget(World world, Set<Coordinates> coordinatesForAction) {
        for (Coordinates coordinates : coordinatesForAction) {
            if (world.getEntity(coordinates) instanceof Herbivore) {
                return coordinates;
            }
        }
        return null;
    }

    @Override
    protected boolean isAvailableCoordinateForAction(Coordinates coordinates, World world) {

        boolean cellIsEmpty = world.isWorldCellEmpty(coordinates);
        boolean cellHasGrass = world.getEntity(coordinates) instanceof Grass;
        boolean cellHasTarget = world.getEntity(coordinates) instanceof Herbivore;

        return cellIsEmpty || cellHasGrass || cellHasTarget;
    }

    public boolean getOnGrassState() {
        return onGrass;
    }

    public void moveToGrass() {
        onGrass = true;
    }

    public void moveFromGrass(Coordinates grassCoordinates, World world) {
        onGrass = false;
        world.setEntity(grassCoordinates, new Grass(grassCoordinates));
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }
}
