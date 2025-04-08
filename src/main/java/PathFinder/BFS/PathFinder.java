package PathFinder.BFS;

import Entities.Creatures.Creature;
import Entities.Creatures.Herbivore;
import Entities.Creatures.Predator;
import Entities.StaticEntities.Grass;
import World.Coordinates;
import World.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PathFinder {

    public static List<Coordinates> getPath(Coordinates coordinates, Creature creature, World world) {

        Queue<Coordinates> cellQueue = new LinkedList<>();
        Set<Coordinates> visitedCells = new HashSet<>();
        HashMap<Coordinates, Coordinates> parents = new HashMap<>();

        cellQueue.add(coordinates);
        Coordinates target = null;
        Coordinates currentCell;

        targetSearch:
        while (!cellQueue.isEmpty()) {

            currentCell = cellQueue.remove();
            visitedCells.add(currentCell);
            List<Coordinates> neighbourCell = getNeighbourCell(currentCell, world);

            for (Coordinates item : neighbourCell) {
                if (world.isWorldCellEmpty(item) && !visitedCells.contains(item)) {
                    cellQueue.add(item);
                    parents.put(item, currentCell);
                } else {
                    if ((creature instanceof Predator) && world.getEntity(item) instanceof Herbivore) {
                        target = item;
                        parents.put(item, currentCell);
                        break targetSearch;
                    }

                    if ((creature instanceof Herbivore) && world.getEntity(item) instanceof Grass) {
                        target = item;
                        parents.put(item, currentCell);
                        break targetSearch;
                    }
                }
            }
        }

        List<Coordinates> path = new ArrayList<>();
        path.add(target);
        Coordinates temp = target;

        while (path.get(path.size() - 1) != coordinates) {
            temp = parents.get(temp);
            path.add(temp);
        }

        Collections.reverse(path);
        return path;
    }

    private static List<Coordinates> getNeighbourCell(Coordinates coordinates, World world) {

        int x;
        int y;

        List<Coordinates> list = new ArrayList<>();

        if ((x = coordinates.getX() - 1) >= 0) {
            list.add(new Coordinates(x, coordinates.getY()));
        }

        if ((x = coordinates.getX() + 1) < world.getWidth()) {
            list.add(new Coordinates(x, coordinates.getY()));
        }

        if ((y = coordinates.getY() - 1) >= 0) {
            list.add(new Coordinates(coordinates.getX(), y));
        }

        if ((y = coordinates.getY() + 1) < world.getHeight()) {
            list.add(new Coordinates(coordinates.getX(), y));
        }

        return list;
    }
}
