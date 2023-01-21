package commands;

import java.util.LinkedHashMap;

public class CommandsDict {
    final static LinkedHashMap<String, Command> commandsManeger = new LinkedHashMap<>();

    void fill() {
        commandsManeger.put("help", new Help());
        commandsManeger.put("info", new Info());
        commandsManeger.put("show", new Show());
        commandsManeger.put("insert", new Insert());
        commandsManeger.put("update", new Update());
        commandsManeger.put("remove_key", new RemoveKey());
        commandsManeger.put("clear", new Clear());
        commandsManeger.put("save", new Save());
        commandsManeger.put("execute_script", new ExecuteScript());
        commandsManeger.put("exit", new Exit());
        commandsManeger.put("history", new History());
        commandsManeger.put("replace_if_greater", new ReplaceIfGreater());
        commandsManeger.put("remove_greater_key", new RemoveGreaterKey());
        commandsManeger.put("filter_by_salary", new FilterBySalary());
        commandsManeger.put("filter_starts_with_name", new FilterStartsWithName());
        commandsManeger.put("filter_less_than_status", new FilterLessThanStatus());
    }

    public CommandsDict() {
        fill();
    }

    public LinkedHashMap<String, Command> getCommandsManger() {
        return commandsManeger;
    }
}
