package Entities.Creatures;

import Entities.StaticEntities.Grass;
import World.Coordinates;
import World.World;

public class Predator extends Creature {

    private static final String SPRITE = " \uD83D\uDC2F ";
    private int atacksPower;
    private boolean onGrass;

    public Predator(Coordinates coordinates) {
        super(coordinates);
        speed = 2;
        health = 100;
        atacksPower = 20;
        onGrass = false;
    }

    @Override
    protected boolean isAvailableCoordinateForMove(Coordinates coordinates, World world) {
        return world.isWorldCellEmpty(coordinates) || world.getEntity(coordinates) instanceof Grass;
    }

    public boolean getOnGrassState() {
        return onGrass;
    }

    public void moveToGrass() {
        onGrass = true;
    }

    public void moveFromGrass(Coordinates grassCoordinates, World world) {
        onGrass = false;
        world.setEntity(grassCoordinates, new Grass(grassCoordinates));
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
