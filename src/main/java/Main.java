import Actions.Action;
import Actions.MoveAction;
import Actions.SpawnRandomAction;
import World.World;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Action> INIT_ACTIONS = new ArrayList<Action>();
    private static ArrayList<Action> TURN_ACTIONS = new ArrayList<Action>();

    public static void main(String[] args) {

        World world = new World();

        INIT_ACTIONS.add(new SpawnRandomAction());
        TURN_ACTIONS.add(new MoveAction());

        Simulation simulation = new Simulation(INIT_ACTIONS, TURN_ACTIONS, world);
        Menu menu = new Menu(simulation);
        menu.start();

        simulation.startSimulation();
    }

}
