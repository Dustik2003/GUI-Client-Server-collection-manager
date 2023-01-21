package commands;

public class Help extends Command {


    public Help() {
        super("вывести справку по доступным командам");
    }

    @Override
    public void execute() {
        for (String cmd : CommandsDict.commandsManeger.keySet()) {
            System.out.println(cmd + ":" + CommandsDict.commandsManeger.get(cmd).getDesc());
        }
    }

}
