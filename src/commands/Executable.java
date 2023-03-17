package commands;

import java.io.IOException;
import java.sql.SQLException;

public interface Executable {
    String execute() throws IOException, ClassNotFoundException, SQLException;
}
