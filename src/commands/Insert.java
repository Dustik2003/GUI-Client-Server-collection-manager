package commands;

import worker.MapWorker;

import java.util.Scanner;

public class Insert extends CommandsWithElements {
    Scanner cin = new Scanner(System.in);

    public Insert() {
        super("добавить новый элемент с заданным ключом");
    }

    @Override
    public void execute() {
        if (!MapWorker.getWorkers().containsKey(Long.parseLong(getArg()))) {
            MapWorker.getWorkers().put(Long.parseLong(getArg()), dataLoader());
        } else {
            System.out.println("!!!Map contains entered id!!!");
        }
    }


}
