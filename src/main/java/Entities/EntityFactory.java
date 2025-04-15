package Entities;

import Entities.Creatures.Herbivore;
import Entities.Creatures.Predator;
import Entities.StaticEntities.Grass;
import Entities.StaticEntities.Rock;
import Entities.StaticEntities.Tree;
import World.Coordinates;

import java.util.Random;

public class EntityFactory {

    private static final int ENTITY_TYPE_COUNT = 5;

    public Entity createRandomEntity(Coordinates coordinates) {

        int entityIndex = (new Random()).nextInt(ENTITY_TYPE_COUNT);

        return switch (entityIndex) {
            case 0 -> new Herbivore(coordinates);
            case 1 -> new Predator(coordinates);
            case 2 -> new Grass(coordinates);
            case 3 -> new Rock(coordinates);
            case 4 -> new Tree(coordinates);
            default -> throw new RuntimeException("Unknown entity. Entity index: " + entityIndex);
        };
    }
}