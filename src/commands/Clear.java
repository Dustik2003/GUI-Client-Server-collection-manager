package commands;

import worker.MapWorker;

public class Clear extends Command {


    public Clear() {
        super("очистить коллекцию");
    }

    @Override
    public String execute() {
        MapWorker.getWorkers().clear();
        return "";
    }
}
