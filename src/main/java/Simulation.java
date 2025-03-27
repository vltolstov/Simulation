import Game.GameAction;
import Game.GameState;
import Game.Menu;
import Utils.ConsoleRenderer;
import World.World;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {

        Menu menu = new Menu();
        World world = GameAction.startSimulation();

        while (GameAction.getGameState() != GameState.STOP) {
            
            ConsoleRenderer.renderWorld(world);

            GameAction.playSimulation(world);
            Thread.sleep(1000);

            menu.selectGameState(GameAction.getGameState());
            ConsoleRenderer.clean();
        }
    }
}
