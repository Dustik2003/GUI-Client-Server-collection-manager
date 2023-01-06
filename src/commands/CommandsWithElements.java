package commands;

import worker.*;

import java.util.Scanner;

public class CommandsWithElements extends CommandWithArg {

    String arg;
    boolean stream;

    public String getArg() {
        return arg;
    }


    boolean yesOrNo(String field){
        if(!this.stream)
            System.out.println("Input y/n if you want input "+field);
        if(cin.nextLine().equals("y"))
            return true;
        return false;
    }
    protected Worker dataLoader() {
        if (!this.stream) {
            System.out.print("Input name:\n>>");
            String name = Worker.setName(cin.nextLine());
            Float x = Coordinates.setX();
            double y = Coordinates.setY();
            Coordinates coordinates = Worker.setCoordinates(new Coordinates(x, y));
            Organization organization = Worker.setOrganization(new Organization(Organization.setEmployeesCount(), Organization.setType()));
            return new Worker(Worker.setName(name), coordinates, 123456d, organization);
        } else {
            String name = cin.nextLine();
            Float x = cin.nextFloat();
            double y = cin.nextDouble();
            int employeesCount = cin.nextInt();
            cin.nextLine();
            OrganizationType organizationType = OrganizationType.valueOf(cin.nextLine());
            return new Worker(Worker.setName(name), Worker.setCoordinates(new Coordinates(x, y)), 123456d, Worker.setOrganization(new Organization(employeesCount, organizationType)));
        }
    }

    @Override
    public void execute() {

    }

    @Override
    public void setCin(Scanner cin) {
        super.setCin(cin);
        this.stream = true;
    }

    @Override
    public void setArg(String arg) {
        this.arg = arg;
    }

    public CommandsWithElements(String desc) {
        super(desc);
        this.stream=false;
    }
}
