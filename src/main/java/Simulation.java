import Actions.Action;
import Entities.Entity;
import Game.GameState;
import Sprites.Sprite;
import Utils.ConsoleRenderer;
import World.Coordinates;
import World.World;

import java.util.ArrayList;

public class Simulation {

    private static GameState GAME_STATE = GameState.ONGOING;
    private static int GAME_LOOPS_COUNT = 0;
    private static ArrayList<Action> INIT_ACTIONS = new ArrayList<Action>();
    private static ArrayList<Action> TURN_ACTIONS = new ArrayList<Action>();
    private static World world;

    public Simulation(ArrayList<Action> initActions, ArrayList<Action> turnActions, World world) {
        Simulation.world = world;
        INIT_ACTIONS = initActions;
        TURN_ACTIONS = turnActions;
        initSimulation();
    }

    public static void nextTurn(World world) {
        for (Action action : TURN_ACTIONS) {
            action.execute(world);
        }
        increaseGameLoopsCount();
    }

    private static void initSimulation() {
        for (Action action : INIT_ACTIONS) {
            action.execute(world);
        }
    }

    public static void startSimulation() {
        GAME_STATE = GameState.ONGOING;

        while (GAME_STATE == GameState.ONGOING) {
            renderWorld();
            nextTurn(world);

            ConsoleRenderer.renderMessage("Current game loop: " + GAME_LOOPS_COUNT);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void pauseSimulation() {
        GAME_STATE = GameState.PAUSE;
    }

    public static void renderWorld() {

        for (int consoleRow = 0; consoleRow < world.getHeight(); consoleRow++) {
            String line = "";

            for (int consoleCol = 0; consoleCol < world.getWidth(); consoleCol++) {
                Coordinates coordinates = new Coordinates(consoleCol, consoleRow);

                if (world.isWorldCellEmpty(coordinates)) {
                    line += Sprite.getEmptySprite();
                } else {
                    Entity entity = world.getEntity(coordinates);
                    line += entity.getSprite();
                }
            }
            System.out.println(line);
        }
    }

    public static void increaseGameLoopsCount() {
        GAME_LOOPS_COUNT++;
    }

    public int getGameLoopsCount() {
        return GAME_LOOPS_COUNT;
    }
}
