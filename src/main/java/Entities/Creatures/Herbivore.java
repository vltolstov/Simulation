package Entities.Creatures;

import Entities.StaticEntities.Grass;
import World.Coordinates;
import World.World;

public class Herbivore extends Creature {

    private static final int SPEED = 1;
    private static final int HEALTH = 100;
    private static final String TARGET_NAME = "Grass";

    public Herbivore(Coordinates coordinates) {
        super(coordinates, SPEED, HEALTH, TARGET_NAME);
    }

    @Override
    public Coordinates makeAttack(Coordinates targetCoordinates, World world) {
        Grass targetGrass = (Grass) world.getEntity(targetCoordinates);
        return targetGrass.getCoordinates();
    }

    @Override
    public boolean isTarget(Coordinates itemCoordinates, World world) {
        return world.getEntity(itemCoordinates) instanceof Grass;
    }
}
