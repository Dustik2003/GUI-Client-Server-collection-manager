package commands;

import java.io.IOException;
import java.util.ArrayList;

public class History extends Command {
    public static ArrayList<String> history = new ArrayList<>(11);

    public static void move(String command) {
        if (history.size() < 11) {
            history.add(command);
        } else {
                history.remove(0);
            history.add(command);
//            history.set(0, command);
        }
    }

    public History() {
        super("вывести последние 11 команд (без их аргументов)");
    }

    public static ArrayList<String> getHistory() {
        return history;
    }

    @Override
    public String execute() throws IOException {

        History.move("history");
        return this.history.toString();
    }
}
