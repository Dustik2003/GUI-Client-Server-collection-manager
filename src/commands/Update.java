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
            if(MapWorker.getWorkers().get(Long.parseLong(getArg())).getOwner().equals(this.login)) {
                MapWorker.getWorkers().replace(Long.parseLong(getArg()), this.worker);
                return "";
            }
            else{
                return "You are not the owner of the entered element";
            }

        }
        else return ("Element with entered id wasn't found");
    }
}
