package commands;

import worker.MapWorker;

public class FilterBySalary extends CommandWithArg {
    public FilterBySalary() {
        super("вывести элементы, значение поля salary которых равно заданному");
    }

    @Override
    public void execute() {
        int i=0;
        for (Long id : MapWorker.getWorkers().keySet()) {
            if (MapWorker.getWorkers().get(id).getSalary() == Double.parseDouble(this.arg))
                i++;
                System.out.println(MapWorker.getWorkers().get(id).toString());
        }
        if(i==0) System.out.println("Element with given parameter not found");
    }
}
