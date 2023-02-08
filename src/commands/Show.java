package commands;

import worker.MapWorker;

import java.util.Collection;

public class Show extends Command {


    @Override
    public void execute() {
        if(MapWorker.workers.isEmpty()) System.out.println("Collection is empty");
        for (Long id : MapWorker.getWorkers().keySet()) {
            System.out.println(id + "=" + MapWorker.getWorkers().get(id).toString());
        }
    }

    public Show() {
        super("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
