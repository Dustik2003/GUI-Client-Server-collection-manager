package commands;

public class Help extends Command {


    public Help() {
        super("вывести справку по доступным командам");
    }

    @Override
    public void execute() {
        for (String cmd: CommandsDict.commandsManger.keySet()){
            System.out.println(cmd+":"+CommandsDict.commandsManger.get(cmd).getDesc());
        }
    }

}
