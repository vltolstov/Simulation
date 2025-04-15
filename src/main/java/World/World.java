package World;

import Entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class World {

    private int width;
    private int height;

    private Random random = new Random();
    private Map<Coordinates, Entity> entities = new HashMap<Coordinates, Entity>();

    public World() {
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void removeEntity(Coordinates coordinates) {
        if (isWorldCellAvailable(coordinates)) {
            entities.remove(coordinates);
        }
    }

    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entity = this.entities.get(from);
        removeEntity(from);
        setEntity(to, entity);
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        if (isWorldCellAvailable(coordinates)) {
            entity.setCoordinates(coordinates);
            entities.put(coordinates, entity);
        }
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public boolean isWorldCellEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public ArrayList<Entity> getEntities() {
        ArrayList<Entity> entities = new ArrayList<Entity>();

        for (Map.Entry<Coordinates, Entity> entry : this.entities.entrySet()) {
            Entity entity = entry.getValue();
            entities.add(entity);
        }

        return entities;
    }

    private boolean isWorldCellAvailable(Coordinates coordinates) {
        if (!entities.containsKey(coordinates)) {
            new RuntimeException("World cell is not available");
        }
        return true;
    }
}
