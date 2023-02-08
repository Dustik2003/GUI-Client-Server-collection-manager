import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.logging.SocketHandler;

import commands.Command;
import commands.CommandsDict;
import commands.History;
import worker.*;


public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        FileReader.readFile("output.csv");
        String st=System.getenv("CollectionFile");
        try{
            FileReader.readFile(st);
        }catch (Exception e){
            System.out.println("FIle was empty or variable wasn't set.(Set the variable CollectionFile by command export)");
            System.out.println("Now Collection is empty!!!");
        }
        while (true) {
            System.out.print(">>");
            String[] commandName = cin.nextLine().trim().split(" ");
            if(commandName[0].equals(""))continue;
            if (new CommandsDict().getCommandsManger().containsKey(commandName[0])) {
                Command cmd = new CommandsDict().getCommandsManger().get(commandName[0]);
                if (commandName.length > 1) cmd.setArg(commandName[1]);
                if (cmd.getArg() != null) {
                    cmd.execute();
                    History.move(commandName[0]);
                } else {
                    System.out.println("Arg can't be null");
                }
            } else {
                System.out.println("The Command wasn't found");
            }

        }


    }


}
