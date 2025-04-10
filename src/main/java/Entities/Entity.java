package Entities;

import World.Coordinates;

public abstract class Entity {

    private static String SPRITE = "";
    public Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    abstract public String getSprite();
}
