package Entities.StaticEntities;

import Entities.Entity;
import World.Coordinates;

public class Rock extends Entity {

    private static final String SPRITE = " \uD83E\uDEA8 ";

    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }

    //камень 🪨

}
