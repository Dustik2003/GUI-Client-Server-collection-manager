package client.GUI;

import worker.Position;

import java.util.Comparator;

public class SortByPosition implements Comparator<Position> {
    @Override
    public int compare(Position o1, Position o2) {
        return o1.compareTo(o2);
    }
}
