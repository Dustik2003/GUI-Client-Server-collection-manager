import java.util.Scanner;

import commands.Command;
import commands.CommandsDict;
import commands.History;
import worker.*;


public class Main {
    static Long key = 0L;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        new MapWorker();
        while (true) {
            System.out.print(">>");
            String[] commandName = cin.nextLine().trim().split(" ");
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
