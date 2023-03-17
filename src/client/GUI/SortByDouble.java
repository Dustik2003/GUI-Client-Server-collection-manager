package client.GUI;

import java.util.Comparator;

public class SortByDouble implements Comparator<Double> {
    @Override
    public int compare(Double o1, Double o2) {
        return Double.compare(o1,o2);
    }
}
