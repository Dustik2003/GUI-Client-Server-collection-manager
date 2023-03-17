package commands;

import java.io.IOException;
import java.sql.SQLException;

public class CommandWithArg extends Command {

    @Override
    public void setArg(String arg) {
        this.arg = arg;
    }

    public CommandWithArg(String desc) {
        super(desc);
        setArg(null);
    }

    @Override
    public String execute() throws IOException, ClassNotFoundException, SQLException {
        return "";
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }
}
