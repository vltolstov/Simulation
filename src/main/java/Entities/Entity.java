package Entities;

import World.Coordinates;

public abstract class Entity {

    public Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public abstract String getSprite();

    //Корневой абстрактный класс для всех существ и объектов существующих в симуляции

}
