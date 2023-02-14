package commands;

public class Exit extends Command {
    public Exit() {
        super("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public String execute() {
        return ("　　　　　／＞　    フ\n" +
                "　　　　　| 　_　 _|\n" +
                "　 　　　／`ミ _x 彡\n" +
                "　　 　 /　　　 　 |\n" +
                "　　　 /　 ヽ　　 ﾉ\n" +
                "　／￣|　　 |　|　|\n" +
                "　| (￣ヽ＿_ヽ_)_)\n" +
                "　＼二つ.");
    }
}
