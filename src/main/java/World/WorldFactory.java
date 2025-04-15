package World;

import Utils.ConsoleRenderer;
import Utils.InputReader;

public class WorldFactory {

    private final static String SETTINGS_WORLD_WIDTH_MESSAGE = "Enter world width:";
    private final static String SETTINGS_WORLD_HEIGHT_MESSAGE = "Enter world height:";

    public World createWorld(World world) {

        ConsoleRenderer.renderMessage(SETTINGS_WORLD_WIDTH_MESSAGE);
        world.setWidth(InputReader.getUserCommands());

        ConsoleRenderer.renderMessage(SETTINGS_WORLD_HEIGHT_MESSAGE);
        world.setHeight(InputReader.getUserCommands());

        return world;
    }
}
