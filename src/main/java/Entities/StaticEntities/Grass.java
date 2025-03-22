package Entities.StaticEntities;

import Entities.Entity;
import World.Coordinates;

public class Grass extends Entity {

    private static final String SPRITE = " \uD83E\uDEBB ";

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    public String getSprite() {
        return SPRITE;
    }

    //трава - ресурс для травоядных 🪻

}
