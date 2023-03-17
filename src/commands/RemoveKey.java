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
            if(MapWorker.getWorkers().get(Long.parseLong(getArg())).getOwner().equals(this.login)) {
                MapWorker.getWorkers().remove(Long.parseLong(getArg()));
                return "";
            }
            else{
                return "You are not the owner of the entered element";
            }
        }
        else return "Element with entered id wasn't found";
    }
}
