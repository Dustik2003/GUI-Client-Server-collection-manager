package client.GUI;

import worker.Coordinates;

import java.util.Comparator;
import java.util.Objects;

public class SortByCoordinates implements Comparator<Coordinates> {
    @Override
    public int compare(Coordinates o1, Coordinates o2) {
            if(o1.getX().equals( o2.getX())){
                return (int) (o1.getY()-o2.getY());
            }
            return (int)(o1.getX()-o2.getX());
    }
}
