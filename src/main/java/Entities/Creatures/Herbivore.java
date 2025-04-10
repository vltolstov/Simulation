package Entities.Creatures;

import Entities.StaticEntities.Grass;
import World.Coordinates;
import World.World;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        sprite = " \uD83D\uDC30 ";
        speed = 1;
        health = 100;
    }

    @Override
    public Coordinates makeAttack(Coordinates targetCoordinates, World world) {
        Grass targetGrass = (Grass) world.getEntity(targetCoordinates);
        return targetGrass.coordinates;
    }
}
