package Entities.Creatures;

import World.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public interface ICreature {

    default Coordinates selectMoveCoordinate(Set<Coordinates> availableCoordinates) {

        Random rand = new Random();
        int randomCoordinatesIndex = rand.nextInt(availableCoordinates.size());

        List<Coordinates> availableCoordinatesList = new ArrayList<>(availableCoordinates);
        Coordinates newRandomCoordinates = availableCoordinatesList.get(randomCoordinatesIndex);

        return newRandomCoordinates;
    }
}
