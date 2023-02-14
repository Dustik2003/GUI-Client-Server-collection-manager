package commands;

import worker.MapWorker;
import worker.Status;
import worker.Worker;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilterLessThanStatus extends CommandWithArg {


    @Override
    public String execute() throws IOException {
        int max;
        try{max = Status.valueOf(this.arg.trim()).getSt();
        }catch (Exception e){
            return "Invalid argument";
        }
        LinkedHashMap<Long, Worker> workers=new LinkedHashMap(MapWorker.workers.keySet().stream().filter(id->MapWorker.workers.get(id).getStatus()!=null &&MapWorker.workers.get(id).getStatus().getSt()<max ).collect(Collectors.toMap(Function.identity(),MapWorker.getWorkers()::get)));

        return   workers.isEmpty()?"Element with given parameter not found":sort(workers);
    }

    public FilterLessThanStatus() {
        super("вывести элементы, значение поля status которых меньше заданного");
    }
}
