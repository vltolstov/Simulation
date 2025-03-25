package Entities.Creatures;

import World.Coordinates;
import World.World;

public class Herbivore extends Creature {

    private static final String SPRITE = " \uD83D\uDC2E ";

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        speed = 1;
        health = 100;
    }

    @Override
    protected boolean isAvailableCoordinateForMove(Coordinates coordinates, World world) {
        // можем идти где пусто
        return world.isWorldCellEmpty(coordinates);
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }

    //Стремятся найти ресурс (траву), может потратить свой ход на движение в сторону травы, либо на её поглощение.

}
