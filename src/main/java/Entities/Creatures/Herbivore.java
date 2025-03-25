package Entities.Creatures;

import World.Coordinates;
import World.CoordinatesShift;
import World.World;

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
    protected Set<CoordinatesShift> getMoveCoordinates(int speed) {

        //здесь логика хода травоядного
        //... учитывая скорость

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
    protected boolean isAvailableCoordinateForMove(Coordinates coordinates, World world) {
        // если пусто то можем идти
        // если не пусто то вернуть тип
        return world.isWorldCellEmpty(coordinates);
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }

    //Стремятся найти ресурс (траву), может потратить свой ход на движение в сторону травы, либо на её поглощение.

}
