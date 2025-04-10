package Entities.Creatures;

import World.Coordinates;
import World.World;

public class Predator extends Creature {

    private final int attackPower;

    public Predator(Coordinates coordinates) {
        super(coordinates);
        sprite = " \uD83D\uDC2F ";
        speed = 2;
        health = 100;
        attackPower = 20;
    }

    @Override
    public Coordinates makeAttack(Coordinates targetCoordinates, World world) {

        Herbivore targetHerbivore = (Herbivore) world.getEntity(targetCoordinates);

        if (targetHerbivore.health <= attackPower) {
            return targetHerbivore.coordinates;
        } else {
            targetHerbivore.health = targetHerbivore.health - attackPower;
            return this.coordinates;
        }
    }
}
