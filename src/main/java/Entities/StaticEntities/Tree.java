package Entities.StaticEntities;

import World.Coordinates;

public class Tree extends TerrainObjects {

    private static final String SPRITE = " \uD83C\uDF33 ";

    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }
}
