package commands;

import worker.MapWorker;

import java.io.IOException;
import java.util.*;

public class RemoveGreaterKey extends CommandWithArg {


    public RemoveGreaterKey() {
        super("удалить из коллекции все элементы, ключ которых превышает заданный");
    }

    @Override
    public String execute() throws IOException {

        History.move("remove_greater_key");
        ArrayList<Long> keys = new ArrayList<>();
        Long minId = Long.parseLong(getArg());
        for (Long id : MapWorker.getWorkers().keySet()) {
            if (id > minId) keys.add(id);
        }
        if(keys.size()==0) {
            return "Element with given parameter not found";
        }
        for (Long id : keys) {
            MapWorker.getWorkers().remove(id);
        }
        return "";
    }
}
