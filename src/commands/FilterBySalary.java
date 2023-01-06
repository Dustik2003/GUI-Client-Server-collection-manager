package commands;

import worker.MapWorker;

public class FilterBySalary extends CommandWithArg{
    public FilterBySalary() {
        super("вывести элементы, значение поля salary которых равно заданному");
    }

    @Override
    public void execute() {
        for (Long id: MapWorker.getWorkers().keySet()) {
            if(MapWorker.getWorkers().get(id).getName().indexOf(arg)==0) System.out.println(MapWorker.getWorkers().get(id).toString());
        }
    }
}
