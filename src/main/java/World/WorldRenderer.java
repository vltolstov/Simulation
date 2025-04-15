package World;

import Entities.Entity;
import Sprites.Sprite;

public final class WorldRenderer {

    private WorldRenderer() {
    }

    public static void renderWorld(World world) {

        renderWorldBorder(world);

        for (int consoleRow = 0; consoleRow < world.getHeight(); consoleRow++) {
            StringBuilder line = new StringBuilder(Sprite.getBorderSprite());

            for (int consoleCol = 0; consoleCol < world.getWidth(); consoleCol++) {
                Coordinates coordinates = new Coordinates(consoleCol, consoleRow);

                if (world.isWorldCellEmpty(coordinates)) {
                    line.append(Sprite.getEmptySprite());
                } else {
                    Entity entity = world.getEntity(coordinates);
                    line.append(Sprite.getSprite(entity));
                }
            }

            line.append(Sprite.getBorderSprite());
            System.out.println(line);
        }

        renderWorldBorder(world);
    }

    public static void renderWorldBorder(World world) {
        StringBuilder border = new StringBuilder();

        for (int consoleCol = 0; consoleCol < world.getWidth(); consoleCol++) {
            border.append(Sprite.getBorderSprite());
        }

        System.out.println(border);
    }

}
