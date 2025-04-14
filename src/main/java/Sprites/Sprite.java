package Sprites;

import Entities.Entity;

public class Sprite {

    public String spriteCode;
    private static final String EMPTY_SPRITE_CODE = "   ";
    private static final String HERBIVORE_SPRITE = " \uD83D\uDC30 ";
    private static final String PREDATOR_SPRITE = " \uD83D\uDC2F ";
    private static final String GRASS_SPRITE = " \uD83C\uDF3F ";
    private static final String ROCK_SPRITE = " \uD83E\uDEA8 ";
    private static final String TREE_SPRITE = " \uD83C\uDF33 ";

    public static String getEmptySprite() {
        return EMPTY_SPRITE_CODE;
    }

    public static String getSprite(Entity entity) {
        switch (entity.getClass().getSimpleName()) {
            case "Herbivore":
                return HERBIVORE_SPRITE;
            case "Predator":
                return PREDATOR_SPRITE;
            case "Grass":
                return GRASS_SPRITE;
            case "Rock":
                return ROCK_SPRITE;
            case "Tree":
                return TREE_SPRITE;
            default:
                throw new RuntimeException("Unknown entity type");
        }
    }

}
