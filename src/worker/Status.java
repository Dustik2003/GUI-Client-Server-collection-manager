package worker;

import java.io.Serializable;

public enum Status implements Serializable {
    FIRED(0),
    RECOMMENDED_FOR_PROMOTION(1),
    REGULAR(2);
    private int st = -1;


    Status(int st) {
        this.st = st;
    }

    public int getSt() {
        return st;
    }
}