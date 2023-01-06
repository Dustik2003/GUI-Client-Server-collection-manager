package commands;

public class Exit extends Command{
    public Exit() {
        super("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
