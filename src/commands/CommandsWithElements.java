package commands;

import worker.*;

import java.io.BufferedReader;
import java.io.IOException;
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


//    boolean yesOrNo(String field) {
//        if (!this.stream)
//            System.out.println("Input y/n if you want input " + field);
//        if (cin.nextLine().equals("y"))
//            return true;
//        return false;
//    }

//    protected Worker dataLoader() {
//        if (!this.stream) {
//            System.out.print("Input name:\n>>");
//            String name = Worker.setName(cin.nextLine());
//            Float x = Coordinates.setX();
//            double y = Coordinates.setY();
//            Coordinates coordinates = Worker.setCoordinates(new Coordinates(x, y));
//            double salary=Worker.setSalary();
//            LocalDate endDate=Worker.setEndDate();
//            Position position=Worker.setPosition();
//            Status status=Worker.setStatus();
//            Organization organization = Worker.setOrganization(new Organization(Organization.setEmployeesCount(), Organization.setType()));
//            return new Worker(Worker.setName(name), coordinates, salary,endDate,position,status, organization);
//        } else {
//            String name = cin.nextLine();
//            Float x = cin.nextFloat();
//            double y = cin.nextDouble();
//            double salary=cin.nextDouble();
//            String st= cin.nextLine();
//            LocalDate endDate=st.equals("")?null:LocalDate.parse(st);
//            cin.nextLine();
//            String posStat=cin.nextLine();
//            Position position=posStat.equals("")?null:Position.valueOf(posStat);
//            posStat=cin.nextLine();
//            Status status=posStat.equals("")?null:Status.valueOf(posStat);
//            int employeesCount = cin.nextInt();
//            cin.nextLine();
//            OrganizationType organizationType = OrganizationType.valueOf(cin.nextLine());
//            return new Worker(Worker.setName(name), Worker.setCoordinates(new Coordinates(x, y)), salary,endDate,position,status, Worker.setOrganization(new Organization(employeesCount, organizationType)));
//        }
//    }



    public void loadElem() throws IOException {
        if (!this.stream) {
            Scanner cin=new Scanner(System.in);
            System.out.print("Input name:\n>>");
            String name = Worker.setName(cin.nextLine());
            Float x = Coordinates.setX();
            double y = Coordinates.setY();
            Coordinates coordinates = Worker.setCoordinates(new Coordinates(x, y));
            double salary=Worker.setSalary();
            LocalDate endDate=Worker.setEndDate();
            Position position=Worker.setPosition();
            Status status=Worker.setStatus();
            Organization organization = Worker.setOrganization(new Organization(Organization.setEmployeesCount(), Organization.setType()));
            this.worker =new Worker(Worker.setName(name), coordinates, salary,endDate,position,status, organization);
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
        this.worker = new Worker(Worker.setName(name), Worker.setCoordinates(new Coordinates(x, y)), salary,endDate,position,status, Worker.setOrganization(new Organization(employeesCount, organizationType)));

    }




    @Override
    public String execute() throws IOException {
return "";
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
        this.stream=true;
    }


    //    @Override
//    public void setCin(Scanner cin) {
//        super.setCin(cin);
//        this.stream = true;
//    }

    @Override
    public void setArg(String arg) {
        this.arg = arg;
    }

    public CommandsWithElements(String desc) {
        super(desc);
        this.stream = false;
    }
}
