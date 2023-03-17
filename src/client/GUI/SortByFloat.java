package client.GUI;

import java.util.Comparator;

public class SortByFloat implements Comparator<Float> {
    @Override
    public int compare(Float o1, Float o2) {
        return Float.compare(o1,o2);
    }
}
