package commands;

import java.util.LinkedHashMap;

public class CommandsDict {
    final static LinkedHashMap<String,Command> commandsManger=new LinkedHashMap<>();
    void fill(){
        commandsManger.put("help",new Help());
        commandsManger.put("info", new Info());
        commandsManger.put("show",new Show());
        commandsManger.put("insert",new Insert());
        commandsManger.put("update",new Update());
        commandsManger.put("remove_key",new RemoveKey());
        commandsManger.put("clear",new Clear());
        commandsManger.put("execute_script",new ExecuteScript());
        commandsManger.put("exit", new Exit());
        commandsManger.put("history",new History());
        commandsManger.put("replace_if_greater",new ReplaceIfGreater());
        commandsManger.put("remove_greater_key",new RemoveGreaterKey());
        commandsManger.put("filter_by_salary",new FilterBySalary());
        commandsManger.put("filter_starts_with_name",new FilterStartsWithName());
        commandsManger.put("filter_less_than_status", new FilterLessThanStatus());
    }

    public CommandsDict() {
        fill();
    }

    public LinkedHashMap<String, Command> getCommandsManger() {
        return commandsManger;
    }
}
