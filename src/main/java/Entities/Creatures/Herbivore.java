package Entities.Creatures;

import Entities.StaticEntities.Grass;
import World.Coordinates;
import World.World;

public class Herbivore extends Creature {

    private static final int SPEED = 1;
    private static final int HEALTH = 100;

    public Herbivore(Coordinates coordinates) {
        super(coordinates, SPEED, HEALTH);
    }

    @Override
    public Coordinates makeAttack(Coordinates targetCoordinates, World world) {
        Grass targetGrass = (Grass) world.getEntity(targetCoordinates);
        return targetGrass.getCoordinates();
    }
}
