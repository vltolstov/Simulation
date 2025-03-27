package Entities.StaticEntities;

import World.Coordinates;

public class Grass extends TerrainObjects {

    private static final String SPRITE = " ♨ ";

    public Grass(Coordinates coordinates) {
        super(coordinates);
    }

    public String getSprite() {
        return SPRITE;
    }

    //трава - ресурс для травоядных 🪻

}
