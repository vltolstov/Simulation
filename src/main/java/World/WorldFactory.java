package World;

import Entities.Entity;
import Entities.EntityFactory;

import java.util.Random;

import static java.lang.Math.round;

public class WorldFactory {

    private static final double WORLD_POPULATION_RATIO = 0.3; // по-умолчанию 0.3
    private Random random = new Random();

    public World createWorld() {

        World world = new World();
        long entityQuantity = round(world.getHeight() * world.getWidth() * WORLD_POPULATION_RATIO);

        for (int i = 0; i < entityQuantity; i++) {

            Coordinates coordinates = world.getRandomCellCoordinates();
            Entity entity = (new EntityFactory()).createRandomEntity(coordinates);

            world.setEntity(coordinates, entity);

        }

        return world;
    }
}
