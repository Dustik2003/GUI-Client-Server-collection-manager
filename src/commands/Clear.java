package commands;

import worker.MapWorker;

public class Clear extends Command {


    public Clear() {
        super("очистить коллекцию");
    }

    @Override
    public void execute() {
        MapWorker.getWorkers().clear();
    }
}
