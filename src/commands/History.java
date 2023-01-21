package commands;

import java.util.ArrayList;

public class History extends Command {
    public static ArrayList<String> history = new ArrayList<>(11);

    public static void move(String command) {
        if (history.size() < 11) {
            history.add(command);
        } else {
            for (int i = 10; i > 0; i--) {
                history.set(i, history.get(i - 1));
            }
            history.set(0, command);
        }
    }

    public History() {
        super("вывести последние 11 команд (без их аргументов)");
    }

    public static ArrayList<String> getHistory() {
        return history;
    }

    @Override
    public void execute() {
        System.out.println(this.history);
    }
}
