package World;

import Entities.Creatures.Creature;
import Entities.Creatures.Predator;
import Entities.Entity;
import Entities.StaticEntities.Grass;
import Utils.ConsoleRenderer;
import Utils.InputReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class World {

    private int width;
    private int height;
    private final static String SETTINGS_WORLD_WIDTH_MESSAGE = "Введите ширину мира:";
    private final static String SETTINGS_WORLD_HEIGHT_MESSAGE = "Введите высоту мира:";

    private Map<Coordinates, Entity> world = new HashMap<Coordinates, Entity>();

    public World() {
        ConsoleRenderer.renderMessage(SETTINGS_WORLD_WIDTH_MESSAGE);
        width = InputReader.getUserDigits();

        ConsoleRenderer.renderMessage(SETTINGS_WORLD_HEIGHT_MESSAGE);
        height = InputReader.getUserDigits();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void removeEntity(Coordinates coordinates) {
        world.remove(coordinates);
    }

    public void moveEntity(Coordinates from, Coordinates to, World world) {
        Entity entity = this.world.get(from);

        if (entity instanceof Predator && this.world.get(to) instanceof Grass) {
            ((Predator) entity).moveToGrass();
            removeEntity(from);
        } else if (entity instanceof Predator && ((Predator) entity).getOnGrassState()) {
            removeEntity(from);
            ((Predator) entity).moveFromGrass(from, world);
        } else {
            removeEntity(from);
        }

        setEntity(to, entity);
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        world.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return world.get(coordinates);
    }

    public boolean isWorldCellEmpty(Coordinates coordinates) {
        return !world.containsKey(coordinates);
    }

    public ArrayList<Creature> getCreatures() {

        ArrayList<Creature> creatures = new ArrayList<Creature>();

        for (Map.Entry<Coordinates, Entity> entry : world.entrySet()) {
            Entity entity = entry.getValue();
            if (entity instanceof Creature) {
                creatures.add((Creature) entity);
            }
        }

        return creatures;
    }
}
