package commands;

import worker.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class CommandsWithElements extends CommandWithArg {

    String arg;
    boolean stream;
    Worker worker;
    transient BufferedReader reader;

    public String getArg() {
        return arg;
    }


    public void loadElem() throws IOException {
        if (!this.stream) {
            Scanner cin=new Scanner(System.in);
            System.out.print("Input name:\n>>");
            String name = Worker.setName(cin.nextLine());
            Float x = Coordinates.setX();
            double y = Coordinates.setY();
            Coordinates coordinates = new Coordinates(x, y);
            double salary=Worker.setSalary();
            LocalDate endDate=Worker.setEndDate();
            Position position=Worker.setPosition();
            Status status=Worker.setStatus();
            Organization organization = new Organization(Organization.setEmployeesCount(), Organization.setType());
            System.out.println(this.login);
            this.worker =new Worker(Worker.setName(name), coordinates, salary,endDate,position,status, organization,this.login);
            return;
        }
        String name = reader.readLine();
        Float x = Float.parseFloat(reader.readLine().trim());
        double y = Double.parseDouble(reader.readLine().trim());
        double salary=Double.parseDouble(reader.readLine().trim());
        String st= reader.readLine().trim();
        LocalDate endDate=st.equals("")?null:LocalDate.parse(st);
//        reader.readLine();
        String posStat= reader.readLine().trim();
        Position position=posStat.equals("")?null:Position.valueOf(posStat);
        posStat= reader.readLine().trim();
        Status status=posStat.equals("")?null:Status.valueOf(posStat);
        int employeesCount = Integer.parseInt(reader.readLine().trim());
//        reader.readLine().trim();
        OrganizationType organizationType = OrganizationType.valueOf(reader.readLine().trim());
        this.worker = new Worker(Worker.setName(name), new Coordinates(x, y), salary,endDate,position,status, new Organization(employeesCount, organizationType),this.login);

    }




    @Override
    public String execute() throws IOException, ClassNotFoundException, SQLException {
return "";
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
        this.stream=true;
    }



    @Override
    public void setArg(String arg) {
        this.arg = arg;
    }

    public CommandsWithElements(String desc) {
        super(desc);
        this.stream = false;
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }
}
