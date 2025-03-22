package Entities.Creatures;

import World.Coordinates;

public class Herbivore extends Creature {

    private static final String SPRITE = " \uD83D\uDC2E ";

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        speed = 1;
        health = 100;
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }

    //Травоядное, наследуется от Entities.Creatures.Creature. 🐮
    //Стремятся найти ресурс (траву), может потратить свой ход на движение в сторону травы, либо на её поглощение.

}
