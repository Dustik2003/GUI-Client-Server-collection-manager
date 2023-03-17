package commands;

import worker.MapWorker;

public class Update extends CommandsWithElements {


    public Update() {
        super("обновить значение элемента коллекции, id которого равен заданному ");
    }

    @Override
    public String execute() {

        History.move("update");

        return "update";
    }
}
