package Entities.StaticEntities;

import World.Coordinates;

public class Rock extends TerrainObjects {

    private static final String SPRITE = " ☖ ";

    public Rock(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }

    //камень 🪨

}
