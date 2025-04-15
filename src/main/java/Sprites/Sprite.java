package Sprites;

import Entities.Entity;

public class Sprite {

    public String spriteCode;
    private static final String EMPTY_SPRITE_CODE = "  ";
    private static final String BORDER_SPRITE = " \uD83C\uDF33 ";
    private static final String HERBIVORE_SPRITE = " \uD83D\uDC30 ";
    private static final String PREDATOR_SPRITE = " \uD83D\uDC2F ";
    private static final String GRASS_SPRITE = " \uD83C\uDF3F ";
    private static final String ROCK_SPRITE = " \uD83E\uDEA8 ";
    private static final String TREE_SPRITE = " \uD83C\uDF33 ";

    public static String getEmptySprite() {
        return EMPTY_SPRITE_CODE;
    }

    public static String getBorderSprite() {
        return BORDER_SPRITE;
    }

    public static String getSprite(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Herbivore" -> HERBIVORE_SPRITE;
            case "Predator" -> PREDATOR_SPRITE;
            case "Grass" -> GRASS_SPRITE;
            case "Rock" -> ROCK_SPRITE;
            case "Tree" -> TREE_SPRITE;
            default -> throw new RuntimeException("Unknown entity type");
        };
    }

}
