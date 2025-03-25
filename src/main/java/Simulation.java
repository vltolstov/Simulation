import Entities.Creatures.Creature;
import Entities.Creatures.Herbivore;
import Entities.Creatures.Predator;
import Entities.Entity;
import Entities.StaticEntities.Rock;
import Utils.ConsoleRenderer;
import World.Coordinates;
import World.World;
import World.WorldFactory;

public class Simulation {

    public static void main(String[] args) {

        GameState state = GameState.ONGOING;
        World world = (new WorldFactory()).createWorld();


        //создаем корову
        Coordinates herbiCoordinates = new Coordinates(1, 1);
        Creature herbivore = new Herbivore(herbiCoordinates);
        world.setEntity(herbiCoordinates, herbivore);

        //создаем камень
        Coordinates rockCoordinates = new Coordinates(0, 0);
        Entity entityRock = new Rock(rockCoordinates);
        world.setEntity(rockCoordinates, entityRock);

        //создаем хищника
        Coordinates predatorCoordinates = new Coordinates(2, 1);
        Entity entityPredator = new Predator(predatorCoordinates);
        world.setEntity(predatorCoordinates, entityPredator);


        while (state != GameState.STOP) {

            ConsoleRenderer.renderWorld(world);
            world.moveEntity(herbivore.coordinates, herbivore.makeMove(world));
            ConsoleRenderer.renderWorld(world);

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
