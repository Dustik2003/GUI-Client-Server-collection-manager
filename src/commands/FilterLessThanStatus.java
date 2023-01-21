package commands;

import worker.MapWorker;
import worker.Status;

public class FilterLessThanStatus extends CommandWithArg {


    @Override
    public void execute() {
        int max = Status.valueOf(getArg()).getSt();
        for (Long id : MapWorker.getWorkers().keySet()) {
            if (MapWorker.getWorkers().get(id).getStatus() != null && max > MapWorker.getWorkers().get(id).getStatus().getSt())
                System.out.println(MapWorker.getWorkers().get(id));
        }
    }

    public FilterLessThanStatus() {
        super("вывести элементы, значение поля status которых меньше заданного");
    }
}
