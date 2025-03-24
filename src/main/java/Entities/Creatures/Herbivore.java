package Entities.Creatures;

import World.Coordinates;
import World.CoordinatesShift;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Herbivore extends Creature {

    private static final String SPRITE = " \uD83D\uDC2E ";

    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        speed = 1;
        health = 100;
    }

    @Override
    protected Set<CoordinatesShift> getMoveCoordinates() {

        //здесь логика хода травоядного
        //...

        //по-умолчанию во все стороны
        return new HashSet<>(Arrays.asList(
                new CoordinatesShift(1, 0),
                new CoordinatesShift(1, 1),
                new CoordinatesShift(0, 1),
                new CoordinatesShift(-1, 1),
                new CoordinatesShift(-1, 0),
                new CoordinatesShift(-1, -1),
                new CoordinatesShift(0, -1),
                new CoordinatesShift(1, -1)
        ));
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }

    //Травоядное, наследуется от Entities.Creatures.Creature. 🐮
    //Стремятся найти ресурс (траву), может потратить свой ход на движение в сторону травы, либо на её поглощение.

}
