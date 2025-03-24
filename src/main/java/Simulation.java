import Entities.Creatures.Herbivore;
import Entities.Entity;
import Utils.ConsoleRenderer;
import World.Coordinates;
import World.World;
import World.WorldFactory;

public class Simulation {

    public static void main(String[] args) {

        GameState state = GameState.ONGOING;
        World world = (new WorldFactory()).createWorld();

        while (state != GameState.STOP) {

            ConsoleRenderer.renderWorld(world);
            Coordinates coordinates = new Coordinates(1, 1);
            Entity entity = new Herbivore(coordinates);
            world.setEntity(coordinates, entity);

            Entity test = world.getEntity(coordinates);
            test.getAvailableCoordinateForMove();

            int a = 123;


            //запуск игры

            Menu menu = new Menu();
            state = menu.selectGameState(state);

        }
    }


    //Главный класс приложения, включает в себя:
    //
    //Карту
    //Счётчик ходов
    //Рендерер поля
    //Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу (детали ниже)
    //
    //Методы:
    //
    //nextTurn() - просимулировать и отрендерить один ход
    //startSimulation() - запустить бесконечный цикл симуляции и рендеринга
    //pauseSimulation() - приостановить бесконечный цикл симуляции и рендеринга

    //Actions #
    //
    //Action - действие, совершаемое над миром.
    //Например - сходить всеми существами.
    //Это действие итерировало бы существ и вызывало каждому makeMove().
    //Каждое действие описывается отдельным классом и совершает операции над картой.
    //Симуляция содержит 2 массива действий:
    //
    //initActions - действия, совершаемые перед стартом симуляции.
    //Пример - расставить объекты и существ на карте
    //turnActions - действия, совершаемые каждый ход.
    //Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало

}
