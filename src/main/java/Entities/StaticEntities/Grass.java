package Entities.StaticEntities;

import World.Coordinates;

public class Grass extends TerrainObjects {

    private static final String SPRITE = " \uD83C\uDF3F ";

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }
}
