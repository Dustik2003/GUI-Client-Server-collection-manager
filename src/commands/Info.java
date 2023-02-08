package commands;

import worker.MapWorker;

public class Info extends Command {
    public Info() {
        super(" вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    public void execute() {
        System.out.println("Type of collection: LinkedHashMap");
        System.out.println("Date of initialization: "+MapWorker.date);
        System.out.println("Count of elements: "+MapWorker.getWorkers().keySet().size());
    }
}
