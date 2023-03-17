package commands;

import worker.MapWorker;

import java.io.IOException;
import java.sql.*;

public class Insert extends CommandsWithElements {

    public Insert() {
        super("добавить новый элемент с заданным ключом");
    }

    @Override
    public String execute() throws IOException, ClassNotFoundException, SQLException {

        History.move("insert");
        MapWorker.getWorkers().put(++MapWorker.id, this.worker);

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studs","s352869", "LMKHLWLfMIyM3ws0");
        Statement st= connection.createStatement();
        st.execute("insert into workers values ('"+this.worker.getOwner()+"',nextval('generator'), '"+this.worker.getName() +"', ("+this.worker.getCoordinates().getX()+","+this.worker.getCoordinates().getY()+" ),'"+this.worker.getCreationDate()+"', "+this.worker.getSalary()+", "+forQuotes(this.worker.getEndDate())+","+forQuotes(this.worker.getPosition())+","+forQuotes(this.worker.getStatus()) +", ("+this.worker.getOrganization().getEmployeesCount()+", "+forQuotes(this.worker.getOrganization().getType()) +"));");
        return "Completed";

    }


    private static String forQuotes(Object o){
        if (o==null)return null;
        else return "'"+o+"'";
    }

    @Override
    public void setArg(String arg) {
        this.arg="";
    }
}
