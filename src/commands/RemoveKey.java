package commands;

import worker.MapWorker;

public class RemoveKey extends CommandWithArg {
    public RemoveKey() {
        super("удалить элемент из коллекции по его ключу");
    }

    @Override
    public void execute() {
        if (MapWorker.getWorkers().containsKey(Long.parseLong(getArg())))
            MapWorker.getWorkers().remove(Long.parseLong(getArg()));
        else System.out.println("Element with entered id wasn't found");
    }
}
