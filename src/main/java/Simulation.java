import Actions.Action;
import Utils.ConsoleRenderer;
import World.World;
import World.WorldRenderer;

import java.util.ArrayList;
import java.util.List;


public class Simulation {

    private static GameState gameState;
    private static int gameLoopCount = 0;
    private List<Action> initActions = new ArrayList<Action>();
    private List<Action> turnActions = new ArrayList<Action>();
    private World world;

    public Simulation(List<Action> initActions, List<Action> turnActions, World world) {
        this.world = world;
        this.initActions = initActions;
        this.turnActions = turnActions;
        initSimulation();
    }

    private void nextTurn(World world) {
        for (Action action : turnActions) {
            action.execute(world);
        }

        WorldRenderer.renderWorld(world);

        increaseGameLoopsCount();
        ConsoleRenderer.renderMessage("Current game loop: " + gameLoopCount);
    }

    private void initSimulation() {
        for (Action action : initActions) {
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
                    Thread.currentThread().interrupt();
                }
            }

            nextTurn(world);
            Menu.showMenu();

            if (gameState == GameState.ONE_LOOP) {
                gameState = GameState.PAUSE;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            notify();
        }
    }

    public synchronized void pauseSimulation() {
        while (gameState == GameState.INFINITY_PLAY) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        notify();
    }

    public synchronized void resumeSimulation() {
        notify();
    }

    private static void increaseGameLoopsCount() {
        gameLoopCount++;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        Simulation.gameState = gameState;
    }
}
