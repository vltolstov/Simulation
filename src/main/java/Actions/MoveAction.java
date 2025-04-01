package Actions;

import World.World;

public class MoveAction extends Action {

    public void execute(World world) {
        world.getCreatures().forEach(creature -> {
            world.moveEntity(creature.coordinates, creature.makeAction(world), world);
        });
    }
}
