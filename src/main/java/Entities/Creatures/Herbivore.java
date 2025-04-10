package Entities.Creatures;

import Entities.StaticEntities.Grass;
import World.Coordinates;
import World.World;

public class Herbivore extends Creature {

    private static final String SPRITE = " ☃ ";

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        speed = 1;
        health = 100;
    }

    @Override
    public Coordinates makeAttack(Coordinates targetCoordinates, World world) {
        Grass targetGrass = (Grass) world.getEntity(targetCoordinates);
        return targetGrass.coordinates;
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }
}
