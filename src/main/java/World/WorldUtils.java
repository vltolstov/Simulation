package World;

import Entities.Creatures.Creature;
import Entities.Entity;

import java.util.ArrayList;

public final class WorldUtils {

    private WorldUtils() {
    }

    public static ArrayList<Creature> getCreatures(World world) {

        ArrayList<Creature> creatures = new ArrayList<Creature>();

        for (Entity entity : world.getEntities()) {
            if (entity instanceof Creature) {
                creatures.add((Creature) entity);
            }
        }

        return creatures;
    }

    public static void moveEntity(World world, Coordinates from, Coordinates to) {
        Entity entity = world.getEntity(from);
        world.removeEntity(from);
        world.setEntity(to, entity);
    }

}
