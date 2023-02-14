package commands;

import worker.MapWorker;
import worker.Worker;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilterStartsWithName extends CommandWithArg {


    public FilterStartsWithName() {
        super("вывести элементы, значение поля name которых начинается с заданной подстроки");
    }

    @Override
    public String execute() throws IOException {
        LinkedHashMap<Long, Worker> workers=new LinkedHashMap(MapWorker.workers.keySet().stream().filter(id->MapWorker.workers.get(id).getName().indexOf(this.arg.trim())==0).collect(Collectors.toMap(Function.identity(),MapWorker.getWorkers()::get)));
        return   workers.isEmpty()?"Element with given parameter not found":sort(workers);
    }
}
