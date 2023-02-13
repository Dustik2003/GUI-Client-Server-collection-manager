package worker;

import java.io.Serializable;

public enum Position implements Serializable {
    MANAGER(4),
    HEAD_OF_DIVISION(3),
    DEVELOPER(2),
    BAKER(1),
    CLEANER(0);

    int ps;

    Position(int ps) {
        this.ps = ps;
    }

    public int getPs() {
        return ps;
    }
}