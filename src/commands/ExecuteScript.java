package commands;

import java.io.*;
import java.util.concurrent.ForkJoinPool;

public class ExecuteScript extends CommandWithArg {
    public ExecuteScript() {
        super("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }

    @Override
    public String execute() throws IOException {
//        History.move("execute_script");

        StringBuilder sb=new StringBuilder();

        BufferedReader reader=new BufferedReader(new InputStreamReader(new ByteArrayInputStream(this.getArg().getBytes())));

        if(this.arg.equals("!!!The file wasn't found!!!")){
            return "";
        }

//        try {
//            setCin(new Scanner(new File(this.arg.trim())));
//        } catch (FileNotFoundException e) {
//            return "!!!The file wasn't found!!!";
//        }
        String text;
        while ((text=reader.readLine())!=null) {
            String[] commandName = text.trim().split(" ");
            if (CommandsDict.getCommands().containsKey(commandName[0])) {
                Command cmd = new CommandsDict().getCommandsManger().get(commandName[0]);
                if (commandName.length > 1) {
                    ((CommandWithArg)cmd).setArg(commandName[1]);
                    if(cmd instanceof CommandsWithElements){
                        ((CommandsWithElements)cmd).setReader(reader);
                        ((CommandsWithElements) cmd).loadElem();
                    }
                }
                if (!arg.equals(cmd.getArg())) {
                    ForkJoinPool forkJoinPool=new ForkJoinPool();

                    String res=forkJoinPool.invoke(cmd);
                    if(res.equals("　　　　　／＞　    フ\n" +
                            "　　　　　| 　_　 _|\n" +
                            "　 　　　／`ミ _x 彡\n" +
                            "　　 　 /　　　 　 |\n" +
                            "　　　 /　 ヽ　　 ﾉ\n" +
                            "　／￣|　　 |　|　|\n" +
                            "　| (￣ヽ＿_ヽ_)_)\n" +
                            "　＼二つ.")) {
                        sb.append(commandName[0]+ ":\n"+res);
                        return sb.toString();
                    }
                    sb.append(commandName[0]+ ":"+"\n\n"+res+"\n");
                } else {
                    sb.append("!!!File exists command with entered filename!!!");
                }
            }
        }

        return sb.toString();
    }


    public boolean equals(Command cmd) {
        return this.getDesc().equals(cmd.getDesc());
    }
}
