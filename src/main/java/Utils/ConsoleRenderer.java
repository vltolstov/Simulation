package Utils;

import World.World;

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
                line += "+";
            }

            System.out.println(line);
        }
        
    }
}