package commands;

import worker.MapWorker;

public class Show extends Command{


    @Override
    public void execute() {
        System.out.println(MapWorker.getWorkers().toString());
    }

    public Show() {
        super("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
