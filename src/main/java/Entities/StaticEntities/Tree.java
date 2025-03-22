package Entities.StaticEntities;

import Entities.Entity;
import World.Coordinates;

public class Tree extends Entity {

    private static final String SPRITE = " \uD83C\uDF33 ";

    public Tree(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }

    //дерево 🌳

}
