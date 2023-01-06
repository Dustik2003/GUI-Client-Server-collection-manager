package commands;

public class CommandWithArg extends Command {

    @Override
    public void setArg(String arg) {
        this.arg=arg;
    }

    public CommandWithArg(String desc) {
        super(desc);
        setArg(null);
    }

    @Override
    public void execute() {

    }
}
