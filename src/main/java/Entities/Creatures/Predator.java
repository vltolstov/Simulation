package Entities.Creatures;

import World.Coordinates;

public class Predator extends Creature {

    private static final String SPRITE = " \uD83D\uDC2F ";
    private int atacksPower;

    public Predator(Coordinates coordinates) {
        super(coordinates);
        speed = 1;
        health = 100;
        atacksPower = 20;
    }

    @Override
    public String getSprite() {
        return SPRITE;
    }

    //Хищник, наследуется от Entities.Creatures.Creature.
    // В дополнение к полям класса Entities.Creatures.Creature, имеет силу атаки.
    // На что может потратить ход хищник:
    //
    //Переместиться (чтобы приблизиться к жертве - травоядному)
    //Атаковать травоядное. При этом количество HP травоядного уменьшается на силу атаки хищника.
    //Если значение HP жертвы опускается до 0, травоядное исчезает

}
