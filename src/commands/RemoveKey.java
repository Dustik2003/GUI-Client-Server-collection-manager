package commands;

import worker.MapWorker;

import java.io.IOException;

public class RemoveKey extends CommandWithArg {
    public RemoveKey() {
        super("удалить элемент из коллекции по его ключу");
    }

    @Override
    public String execute() throws IOException {

        History.move("remove_key");
        if (MapWorker.getWorkers().containsKey(Long.parseLong(getArg()))) {
            MapWorker.getWorkers().remove(Long.parseLong(getArg()));
            return "";
        }
        else return "Element with entered id wasn't found";
    }
}
