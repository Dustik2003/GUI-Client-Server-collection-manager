package commands;

import worker.MapWorker;

public class Update extends CommandsWithElements {


    public Update() {
        super("обновить значение элемента коллекции, id которого равен заданному ");
    }

    @Override
    public String execute() {

        History.move("update");
        if (MapWorker.getWorkers().containsKey(Long.parseLong(getArg()))) {
            MapWorker.getWorkers().replace(Long.parseLong(getArg()), this.worker);
            return "";
        }
        else return ("Element with entered id wasn't found");
    }
}
