package Entities;

import World.Coordinates;

public abstract class Entity {

    protected String sprite;
    public Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getSprite() {
        return sprite;
    }
}
