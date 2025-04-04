import Actions.Action;
import Entities.Entity;
import Game.GameState;
import Sprites.Sprite;
import Utils.ConsoleRenderer;
import World.Coordinates;
import World.World;

import java.util.ArrayList;

public class Simulation {

    private static GameState gameState;
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

        renderWorld();
        ConsoleRenderer.renderMessage("Current game loop: " + GAME_LOOPS_COUNT);
    }

    private static void initSimulation() {
        for (Action action : INIT_ACTIONS) {
            action.execute(world);
        }
        gameState = GameState.INFINITY_PLAY;
    }

    public synchronized void startSimulation() {

        while (gameState != GameState.STOP) {

            if (gameState == GameState.PAUSE) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }

            nextTurn(world);
            Menu.showMenu();

            // один проход
//            if (gameState == GameState.ONE_LOOP) {
//                gameState = GameState.PAUSE;
//            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            notify();
        }
    }

    public synchronized void pauseSimulation() {

        while (gameState == GameState.INFINITY_PLAY) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        notify();
    }

    public synchronized void resumeSimulation() {
        gameState = GameState.INFINITY_PLAY;
        notify();
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

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        Simulation.gameState = gameState;
    }
}
