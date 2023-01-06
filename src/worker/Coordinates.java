package worker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Coordinates implements Validatable {
    private Float x; //Поле не может быть null
    private double y;

    public Coordinates(Float x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Float setX() {
        Float x=null;
        boolean flag=false;
        System.out.print("Input coordinates.x:\n>>");
        try{
            x=new Scanner(System.in).nextFloat();
        }catch(InputMismatchException ex){flag=true;}
        while(x==null || flag){
            flag=false;
            System.out.print("!!!Input coordinates.x again!!!(Coordinates.x can't be equals null)\n>>");
            try{
                x=new Scanner(System.in).nextFloat();
            }catch(InputMismatchException ex){
                flag=true;
            }
        }
        return x;
    }


    public static double setY() {
        double y=0;
        boolean flag=false;
        System.out.print("Input coordinates.y:\n>>");
        try{
            y=new Scanner(System.in).nextDouble();
        }catch(InputMismatchException ex){flag=true;}
        while(flag){
            flag=false;
            System.out.print("!!!Input coordinates.y again!!!\n>>");
            try{
                y=new Scanner(System.in).nextDouble();
            }catch(InputMismatchException ex){
                flag=true;
            }
        }
        return y;
    }



    @Override
    public boolean validate() {
        return x!=null;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}