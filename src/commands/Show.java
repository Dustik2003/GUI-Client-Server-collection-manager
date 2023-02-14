package commands;

import worker.MapWorker;

import java.io.IOException;


public class Show extends Command {


    @Override
    public String execute() throws IOException {
        History.move("show");
        if(MapWorker.workers.isEmpty())return "Collection is empty";
        else return sort(MapWorker.getWorkers());
    }

    public Show() {
        super("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
