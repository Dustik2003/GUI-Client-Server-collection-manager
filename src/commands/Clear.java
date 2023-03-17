package commands;

import worker.MapWorker;

public class Clear extends Command {


    public Clear() {
        super("очистить коллекцию");
    }

    @Override
    public String execute() {

        for(Long id:MapWorker.getWorkers().keySet()){

            if(MapWorker.getWorkers().get(id).getOwner().equals(this.login)){
                MapWorker.getWorkers().remove(id);
            }

        }

        return "";
    }
}
