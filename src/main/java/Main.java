import Actions.Action;
import Actions.MoveAction;
import Actions.SpawnRandomAction;
import Game.GameState;
import World.World;

import java.util.ArrayList;

public class Main {

    private static int GAME_LOOPS_COUNT = 0;
    private static GameState GAME_STATE;
    private static ArrayList<Action> INIT_ACTIONS = new ArrayList<Action>();
    private static ArrayList<Action> TURN_ACTIONS = new ArrayList<Action>();

    public static void main(String[] args) {

        World world = new World();

        INIT_ACTIONS.add(new SpawnRandomAction());
        TURN_ACTIONS.add(new MoveAction());

//        Menu menu = new Menu();
//        menu.start();

        Simulation simulation = new Simulation(INIT_ACTIONS, TURN_ACTIONS, world);
        simulation.startSimulation();

//        menu.setGameState(GameState.ONGOING);
//        menu.start();

    }

}
