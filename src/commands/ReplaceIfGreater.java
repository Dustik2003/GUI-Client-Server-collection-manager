package commands;

import worker.MapWorker;
import worker.Worker;

import java.io.IOException;

public class ReplaceIfGreater extends CommandsWithElements {


    public ReplaceIfGreater() {
        super("заменить значение по ключу, если новое значение больше старого");
    }

    @Override
    public String execute() throws IOException {

        History.move("replace_if_greater");
        if (MapWorker.getWorkers().containsKey(Long.parseLong(getArg()))) {
            if (worker.moreThan(MapWorker.getWorkers().get(Long.parseLong(getArg()))))
                MapWorker.getWorkers().replace(Long.parseLong(getArg()), this.worker);
            return "";
        } else {
            return "Element with entered id wasn't found";
        }
    }
}
