package Utils;

import Entities.Entity;
import Entities.StaticEntities.Grass;
import Sprites.Sprite;
import World.World;
import World.Coordinates;

public class ConsoleRenderer {

    private static final String ERROR_MESSAGE = "Ошибка ввода. Попробуйте еще раз";

    public static void renderMessage(String message){
        System.out.println(message);
    }

    public static void renderErrorMessage(){
        System.out.println(ERROR_MESSAGE);
    }
    
    public static void renderWorld(World world){

        for (int consoleRow = 0; consoleRow < world.getHeight(); consoleRow++) {

            String line = "";

            for(int consoleCol = 0; consoleCol < world.getWidth(); consoleCol++) {

                Coordinates coordinates = new Coordinates(consoleCol, consoleRow);

                if(world.isWorldCellEmpty(coordinates)){
                    line += Sprite.getEmptySprite();
                } else {
                    Entity entity = world.getEntity(coordinates);
                    line += entity.getSprite();
                }

            }

            System.out.println(line);
        }
    }
}