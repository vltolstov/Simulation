package Actions;

import World.World;
import World.WorldUtils;

public class MoveAction extends Action {

    public void execute(World world) {
        WorldUtils.getCreatures(world).forEach(creature -> {
            WorldUtils.moveEntity(world, creature.getCoordinates(), creature.makeAction(world));
        });
    }
}
