package commands;

import java.util.Scanner;

public abstract class Command implements Executable {
    Scanner cin = new Scanner(System.in);
    private final String desc;
    String arg = "";

    public Command(String title) {
        this.desc = title;
    }

    public String getDesc() {
        return desc;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public void setCin(Scanner cin) {
        this.cin = cin;

    }
}