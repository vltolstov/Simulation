package Game;

import World.World;

public class GameAction {

    public static void nextTurn(World world) {
        playSimulation(world);
        //pauseSimulation();
    }

    public static void playSimulation(World world) {
        world.getCreatures().forEach(creature -> {
            world.moveEntity(creature.coordinates, creature.makeAction(world), world);
        });
    }
}
