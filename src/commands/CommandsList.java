package commands;

public enum CommandsList {
//    HELP("help", new Help(),"вывести справку по доступным командам")
//    INFO("info",new Info("info"), "вывести в стандартный поток вывода информацию о коллекции" +
//            " (тип, дата инициализации, количество элементов и т.д.)"),
//    SHOW("show",, "вывести в стандартный поток вывода все элементы коллекции в строковом представлении"),
//    INSERT("insert","{element} : добавить новый элемент с заданным ключом"),
//    UPDATE("update [0-9]+$", "id {element}: обновить значение элемента коллекции, id которого равен заданному"),
//    REMOVE_KEY("remove_key","удалить элемент из коллекции по его ключу"),
//    CLEAR("clear", "очистить коллекцию"),
//    SAVE("save", "сохранить коллекцию в файл"),
//    EXECUTE_SCRIPT("execute_script .*\\.txt$", "file_name :считать и исполнить скрипт из указанного файла." +
//            " В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."),
//    EXIT("exit", "завершить программу (без сохранения в файл)"),
//    HISTORY("history", "вывести последние 11 команд (без их аргументов)"),
//
//    ADD_IF_MAX("add_if_max", "{element} : добавить новый элемент в коллекцию, если его значение" +
//            " превышает значение наибольшего элемента этой коллекции"),
//    ADD_IF_MIN("add_if_min", "{element} : добавить новый элемент в коллекцию, если его значение меньше, " +
//            "чем у наименьшего элемента этой коллекции"),
//    REMOVE_GREATER_KEY("remove_greater_key", "null: удалить из коллекции все элементы, превышающие заданный"),
    ;

    private final String title;
    //    private final Command commandPattern;
    private final String description;

    CommandsList(String title, Command commandPattern, String description) {
        this.title = title;
        this.description = description;
//        this.commandPattern = commandPattern;
    }

    public Command makeCommand() {
        return null;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
    //    insert null {element},
//    update id {element},
//    remove_key null ,
//    clear ,
//    save,
//    execute_script file_name,
//            exit,
//    history ;
//    replace_if_greater null {element} ;
//    remove_greater_key null ;
//    filter_by_salary salary;
//    filter_starts_with_name name;
//    filter_less_than_status status;
//

}
