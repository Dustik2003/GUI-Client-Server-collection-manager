package client;

import java.util.Scanner;

public class CheckInput {

    public static int checkInt(String text){
        Integer a;
        Scanner cin=new Scanner(System.in);
        try{
            System.out.print(text);
            a=cin.nextInt();
        }catch (Exception e){
            a=null;
            cin.nextLine();
        }
        while(a==null){
            try{
                System.out.print("!!!Error try again!!!\n>>");
                a=cin.nextInt();
            }catch (Exception e){
                a=null;
                cin.nextLine();
            }
        }
        return a;
    }



    public static String checkString(String text){
        String a;
        Scanner cin=new Scanner(System.in);
        System.out.print(text);
        a=cin.nextLine().trim();
        while(a.length()<8 || a.length()>32){
            System.out.print("!!Login or Password can\'t be empty!!(8-32 chars)\n>>");
            a=cin.nextLine().trim();
        }
        return a;
    }

}
