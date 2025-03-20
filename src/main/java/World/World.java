package World;

import Entities.Entity;
import Entities.StaticEntities.Grass;
import Utils.InputReader;
import Utils.Notifier;

import java.util.HashMap;
import java.util.Map;

public class World {

    private final int worldWidth;
    private final int worldHeight;
    private final static String SETTINGS_WORLD_WIDTH_MESSAGE = "Введите ширину мира:";
    private final static String SETTINGS_WORLD_HEIGHT_MESSAGE = "Введите высоту мира:";

    private Map<Coordinates, Entity> world = new HashMap<Coordinates, Entity>();

    public World () {
        Notifier.showMessage(SETTINGS_WORLD_WIDTH_MESSAGE);
        worldWidth = InputReader.getUserDigits();

        Notifier.showMessage(SETTINGS_WORLD_HEIGHT_MESSAGE);
        worldHeight = InputReader.getUserDigits();
    }

    public void setEntities(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        world.put(coordinates, entity);
    }

    public void setupDefault() {

        for(int x = 0; x < worldWidth; x++) {
            for(int y = 0; y < worldHeight; y++) {
                setEntities(new Coordinates(x, y), new Grass(new Coordinates(x, y)));
            }
        }

    }
    //Карта, содержит в себе коллекцию для хранения существ и их расположения.
    //Советую не спешить использовать двумерный массив или список списков, а подумать какие ещё коллекции могут подойти.

}
