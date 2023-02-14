package commands;

import worker.MapWorker;

import java.io.IOException;

public class Insert extends CommandsWithElements {

    public Insert() {
        super("добавить новый элемент с заданным ключом");
    }

    @Override
    public String execute() throws IOException {

        History.move("insert");
        if (!MapWorker.getWorkers().containsKey(Long.parseLong(getArg()))) {
            MapWorker.getWorkers().put(Long.parseLong(getArg()), this.worker);
            return "";
        } else {
            return "!!!Map contains entered id!!!";
        }
    }


}
