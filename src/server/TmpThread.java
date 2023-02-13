package server;

import commands.Command;
import commands.Save;

import java.io.IOException;
import java.util.Scanner;

public class TmpThread extends Thread{
    public TmpThread(String name) {
        super(name);
    }

    public void run(){
        Scanner cin=new Scanner(System.in);
        while(true){
            String cmdName=cin.nextLine().trim();
            if(cmdName.equals("save")){
                 Save save=new Save();
                save.execute();
            }else{
                System.out.println("The server can't execute the entered command or the command wasn't found.Try again");
            }

        }


    }

}
