package commands;

import worker.MapWorker;

public class Show extends Command {


    @Override
    public void execute() {
        for (Long id : MapWorker.getWorkers().keySet()) {
            System.out.println(id + "=" + MapWorker.getWorkers().get(id).toString());
        }
    }

    public Show() {
        super("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
