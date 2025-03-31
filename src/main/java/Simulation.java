import Game.Game;
import Game.GameState;
import Game.Menu;
import World.World;
import World.WorldFactory;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {

        World world = (new WorldFactory()).createWorld();

        Menu menu = new Menu();
        menu.setGameState(GameState.ONGOING);
        menu.start();

        Game game = new Game();
        game.loop(menu, world);
        game.start();

    }
}
