package commands;

import java.io.IOException;

public class Help extends Command {


    public Help() {
        super("вывести справку по доступным командам");
    }

    @Override
    public String execute() throws IOException {

//        History.move("help");
        StringBuilder sb=new StringBuilder();
        for (String cmd : CommandsDict.getCommands().keySet()) {
            sb.append(cmd + ":" + CommandsDict.getCommands().get(cmd).getDesc()+"\n");
        }
        return sb.toString();
    }

}
