package World;

import Entities.Entity;
import Utils.ConsoleRenderer;
import Utils.InputReader;

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
}
