package commands;

public class Info extends Command{
    public Info() {
        super(" вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    public void execute() {
        System.out.println("Info");
    }
}
