package commands;

import worker.MapWorker;

import java.io.IOException;

public class Info extends Command {
    public Info() {
        super(" вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    public String execute() throws IOException {
        History.move("info");
        StringBuilder sb=new StringBuilder();
        sb.append("Type of collection: LinkedHashMap\nDate of initialization: "+MapWorker.date+"\nCount of elements: "+MapWorker.getWorkers().keySet().size());
        return sb.toString();
    }
}
