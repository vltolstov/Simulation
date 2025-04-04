import Actions.Action;
import Entities.Entity;
import Game.GameState;
import Game.Menu;
import Sprites.Sprite;
import Utils.ConsoleRenderer;
import World.Coordinates;
import World.World;

import java.util.ArrayList;

public class Simulation {

    private static int GAME_LOOPS_COUNT = 0;
    private static ArrayList<Action> INIT_ACTIONS = new ArrayList<Action>();
    private static ArrayList<Action> TURN_ACTIONS = new ArrayList<Action>();
    private static World world;
    private static Menu menu;
    private static final Object mutex = new Object();

    public Simulation(ArrayList<Action> initActions, ArrayList<Action> turnActions, World world) {
        Simulation.menu = new Menu();
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
        menu.setGameState(GameState.ONGOING);
    }

    public void startSimulation() {

        Thread thread = createSimulationThread();
        thread.start();

        while (menu.getGameState() == GameState.ONGOING) {
            menu.selectGameState(mutex);
        }
        //thread.interrupt();
    }

    public static Thread createSimulationThread() {

        return new Thread(() -> {
            while (menu.getGameState() != GameState.STOP) {

                synchronized (mutex) {
                    while (menu.getGameState() == GameState.PAUSE) {
                        try {
                            menu.selectGameState(mutex);
                            mutex.wait();
                        } catch (InterruptedException e) {
                            if (!menu.getGameState().equals(GameState.ONGOING)) {
                                return;
                            }
                        }
                    }
                }

                nextTurn(world);
                renderWorld();
                

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                ConsoleRenderer.renderMessage("Current game loop: " + GAME_LOOPS_COUNT);
            }
        });
    }

    public static void pauseSimulation() {
        menu.setGameState(GameState.PAUSE);
    }

    public void resumeSimulation() {
        menu.setGameState(GameState.ONGOING);

        synchronized (mutex) {
            mutex.notify();
        }
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
