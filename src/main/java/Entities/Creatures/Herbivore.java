package Entities.Creatures;

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
    protected boolean isAvailableCoordinateForAction(Coordinates coordinates, World world) {
        return world.isWorldCellEmpty(coordinates);
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }
}
