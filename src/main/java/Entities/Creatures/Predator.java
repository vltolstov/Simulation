package Entities.Creatures;

import World.Coordinates;
import World.World;

public class Predator extends Creature {

    private static final int SPEED = 2;
    private static final int HEALTH = 100;
    private static final int ATTACK_POWER = 20;
    private static final String TARGET_NAME = "Herbivore";

    public Predator(Coordinates coordinates) {
        super(coordinates, SPEED, HEALTH, TARGET_NAME);
    }

    public static int getAttackPower() {
        return ATTACK_POWER;
    }

    @Override
    public Coordinates makeAttack(Coordinates targetCoordinates, World world) {

        Herbivore targetHerbivore = (Herbivore) world.getEntity(targetCoordinates);

        if (targetHerbivore.health <= getAttackPower()) {
            return targetHerbivore.getCoordinates();
        } else {
            targetHerbivore.health = targetHerbivore.health - getAttackPower();
            return this.getCoordinates();
        }
    }

    @Override
    public boolean isTarget(Coordinates itemCoordinates, World world) {
        return world.getEntity(itemCoordinates) instanceof Herbivore;
    }
}
