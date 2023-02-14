package worker;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Coordinates implements Validatable, Serializable {
    private Float x; //Поле не может быть null
    private double y;

    public Coordinates(Float x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Float setX() {
        Float x = null;
        boolean flag = false;
        System.out.print("Input coordinates.x:\n>>");
        String st=new Scanner(System.in).nextLine().trim();
        try {
            x = Float.parseFloat(st);
        } catch (InputMismatchException|NumberFormatException ex) {
            flag = true;
        }
        while (x == null || flag) {
            flag = false;
            System.out.print("!!!Input coordinates.x again!!!(Coordinates.x can't be equals null)\n>>");
            try {
                st=new Scanner(System.in).nextLine().trim();
                x = Float.parseFloat(st);
            } catch (InputMismatchException|NumberFormatException ex) {
                flag = true;
            }
        }
        return x;
    }


    public static double setY() {
        double y = 0;
        boolean flag = false;
        System.out.print("Input coordinates.y:\n>>");
        String st=new Scanner(System.in).nextLine().trim();
        try {
            y = Double.parseDouble(st);
        } catch (InputMismatchException|NumberFormatException ex) {
            flag = true;
        }
        while (flag|| st.equals("")) {
            flag = false;
            System.out.print("!!!Input coordinates.y again!!!\n>>");
            try {
                st=new Scanner(System.in).nextLine().trim();
                y = Double.parseDouble(st);
            } catch (InputMismatchException|NumberFormatException ex) {
                flag = true;
            }
        }
        return y;
    }

    public double getY() {
        return y;
    }

    public Float getX() {
        return x;
    }

    @Override
    public boolean validate() {
        return x != null;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}