package worker;

import java.util.Date;
import java.util.Scanner;


public class Worker {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate = new Date(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double salary; //Значение поля должно быть больше 0
    private Date endDate; //Поле может быть null
    private Position position; //Поле может быть null
    private Status status; //Поле может быть null
    private Organization organization; //Поле не может быть null


    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public double getSalary() {
        return salary;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Position getPosition() {
        return position;
    }

    public Organization getOrganization() {
        return organization;
    }

    public static String setName(String name) {
        while (name == null || name.equals("")) {
            System.out.print("!!!Input name again!!!(Name can't be empty or equals null)\n>>");
            name = new Scanner(System.in).nextLine();
        }
        return name;
    }

    public static Coordinates setCoordinates(Coordinates coordinates) {
        boolean flag = false;
        while (coordinates == null || !coordinates.validate() || flag) {
            flag = false;
            System.out.println("!!!Input coordinates again!!!(Coordinates can't be equals null or coordinates.x=null)");
            Float x = Coordinates.setX();
            double y = Coordinates.setX();
            coordinates = new Coordinates(x, y);
        }
        return coordinates;
    }


    public static Double setSalary(double salary) {
        while (salary <= 0) {
            System.out.print("!!!Input salary again!!!(Salary must be more than 0)\n>>");
            salary = new Scanner(System.in).nextDouble();
        }
        return salary;
    }

    public static Organization setOrganization(Organization organization) {
        while (organization == null && !organization.validate()) {
            System.out.print("!!!Input organization again!!!(Organization can't be null, emloyees count must be more than 0 and OrganizationType takes one of the values:\nGOVERNMENT,\nTRUST,\nOPEN_JOINT_STOCK_COMPANY)\n>>");

            organization = new Organization(new Scanner(System.in).nextInt(), OrganizationType.valueOf(new Scanner(System.in).nextLine()));
        }
        return organization;
    }

    public boolean moreThan(Worker worker) {
        if (worker.position == null)
            return false;
        if (this.position == null)
            return true;
        return (this.position.getPs() > worker.position.getPs()) || (this.position.getPs() == worker.position.getPs() && this.salary > worker.salary);
    }


    public Worker(String name, Coordinates coordinates, double salary, Position position, Status status, Organization organization) {
        this.name = setName(name);
        this.coordinates = setCoordinates(coordinates);
//        this.creationDate = new Date();
        this.salary = setSalary(salary);
        this.position = position;
        this.status = status;
        this.organization = setOrganization(organization);
    }

    public Worker(String name, Coordinates coordinates, double salary, Date endDate, Status status, Organization organization) {
        this.name = setName(name);
        this.coordinates = setCoordinates(coordinates);
//        this.creationDate = new Date();
        this.salary = setSalary(salary);
        this.endDate = endDate;
        this.status = status;
        this.organization = setOrganization(organization);
    }

    public Worker(String name, Coordinates coordinates, double salary, Date endDate, Position position, Organization organization) {
        this.name = setName(name);
        this.coordinates = setCoordinates(coordinates);
//        this.creationDate = new Date();
        this.salary = setSalary(salary);
        this.endDate = endDate;
        this.position = position;
        this.organization = setOrganization(organization);
    }

    public Worker(String name, Coordinates coordinates, double salary, Status status, Organization organization) {
        this.name = setName(name);
        this.coordinates = setCoordinates(coordinates);
//        this.creationDate = new Date();
        this.salary = setSalary(salary);
        this.status = status;
        this.organization = setOrganization(organization);
    }

    public Worker(String name, Coordinates coordinates, double salary, Date endDate, Position position, Status status, Organization organization) {
        this.name = setName(name);
        this.coordinates = setCoordinates(coordinates);
//        this.creationDate = new Date();
        this.salary = setSalary(salary);
        this.endDate = endDate;
        this.position = position;
        this.status = status;
        this.organization = setOrganization(organization);
    }

    public Worker(String name, Coordinates coordinates, double salary, Organization organization) {
        this.name = setName(name);
        this.coordinates = setCoordinates(coordinates);
        this.salary = setSalary(salary);
        this.organization = setOrganization(organization);
//        this.creationDate = new Date();
    }

    public Worker(String name, Coordinates coordinates, Date creationDate, double salary, Date endDate, Position position, Status status, Organization organization) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.endDate = endDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", salary=" + salary +
                ", endDate=" + endDate +
                ", position=" + position +
                ", status=" + status +
                ", organization=" + organization +
                '}';
    }

    public Worker(String name) {
        this.name = name;
    }


}