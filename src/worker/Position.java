package worker;

import java.io.Serializable;

public enum Position implements Serializable {
    CLEANER(0),
    BAKER(1),
    DEVELOPER(2),
    HEAD_OF_DIVISION(3),
    MANAGER(4);

    int ps;

    Position(int ps) {
        this.ps = ps;
    }

    public int getPs() {
        return ps;
    }
}