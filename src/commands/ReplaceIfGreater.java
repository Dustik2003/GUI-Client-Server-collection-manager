package commands;

import worker.MapWorker;
import worker.Worker;

public class ReplaceIfGreater extends CommandsWithElements {


    public ReplaceIfGreater() {
        super("удалить элемент из коллекции по его ключу");
    }

    @Override
    public void execute() {
        if (MapWorker.getWorkers().containsKey(Long.parseLong(getArg()))) {
            Worker worker = dataLoader();
            if (worker.moreThan(MapWorker.getWorkers().get(Long.parseLong(getArg()))))
                MapWorker.getWorkers().replace(Long.parseLong(getArg()), worker);
        } else {
            System.out.println("Element with entered id wasn't found");
        }
    }
}
