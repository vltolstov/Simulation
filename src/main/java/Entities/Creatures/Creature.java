package Entities.Creatures;

import Entities.Entity;
import World.Coordinates;

public abstract class Creature extends Entity implements moveable {

    //Абстрактный класс, наследуется от Entities.Entity.
    //Существо, имеет скорость (сколько клеток может пройти за 1 ход), количество HP.
    protected int speed;
    protected int health;

    public Creature(Coordinates coordinates) {
        super(coordinates);
    }

    public void makeMove() {
        //Имеет метод makeMove() - сделать ход.
    }


}
