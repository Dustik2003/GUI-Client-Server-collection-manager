package commands;

import worker.MapWorker;
import worker.Status;

public class FilterLessThanStatus extends CommandWithArg {


    @Override
    public void execute() {
        int max = Status.valueOf(getArg()).getSt();
        int i=0;
        for (Long id : MapWorker.getWorkers().keySet()) {
            if (MapWorker.getWorkers().get(id).getStatus() != null && max > MapWorker.getWorkers().get(id).getStatus().getSt()) {
                System.out.println(MapWorker.getWorkers().get(id));
                continue;
            }
            i++;
        }
        if(i==0)System.out.println("Element with given parameter not found");
    }

    public FilterLessThanStatus() {
        super("вывести элементы, значение поля status которых меньше заданного");
    }
}
