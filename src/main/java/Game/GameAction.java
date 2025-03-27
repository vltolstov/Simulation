package Game;

import World.World;
import World.WorldFactory;

public class GameAction {

    private static GameState gameState = GameState.ONGOING;

    public static void nextTurn(World world) {
        playSimulation(world);
        pauseSimulation();
    }

    public static World startSimulation() {
        gameState = GameState.ONGOING;
        World world = (new WorldFactory()).createWorld();
        playSimulation(world);
        return world;
    }

    public static void playSimulation(World world) {
        gameState = GameState.ONGOING;
        world.getCreatures().forEach(creature -> {
            world.moveEntity(creature.coordinates, creature.makeAction(world), world);
        });
    }

    public static GameState pauseSimulation() {
        gameState = GameState.PAUSE;
        return gameState;
    }

    public static GameState stopSimulation() {
        gameState = GameState.STOP;
        return gameState;
    }

    public static GameState getGameState() {
        return gameState;
    }
}
