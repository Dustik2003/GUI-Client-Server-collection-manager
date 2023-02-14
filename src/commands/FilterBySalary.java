package commands;

import worker.MapWorker;
import worker.Worker;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilterBySalary extends CommandWithArg {
    public FilterBySalary() {
        super("вывести элементы, значение поля salary которых равно заданному");
    }

    @Override
    public String execute() throws IOException {
        double salary;
        try{
            salary = Double.parseDouble(this.arg.trim());
        }catch (Exception e){
            return "Invalid argument";
        }
        LinkedHashMap<Long, Worker> workers=new LinkedHashMap(MapWorker.workers.keySet().stream().filter(id->MapWorker.workers.get(id).getSalary()==salary).collect(Collectors.toMap(Function.identity(),MapWorker.getWorkers()::get)));

        return workers.isEmpty()?"Element with given parameter not found":sort(workers);
    }
}
