import Actions.Action;
import Actions.MoveAction;
import Actions.SpawnRandomAction;
import World.World;
import World.WorldFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Action> INIT_ACTION = new ArrayList<Action>();
    private static final List<Action> TURN_ACTIONS = new ArrayList<Action>();

    public static void main(String[] args) {

        World world = (new WorldFactory().createWorld(new World()));

        INIT_ACTION.add(new SpawnRandomAction());
        TURN_ACTIONS.add(new MoveAction());

        Simulation simulation = new Simulation(INIT_ACTION, TURN_ACTIONS, world);
        Menu menu = new Menu(simulation);
        menu.start();

        simulation.startSimulation();
    }
}
