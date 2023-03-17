package worker;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Worker implements Serializable {
    private String owner;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate = new Date(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double salary; //Значение поля должно быть больше 0
    private LocalDate endDate; //Поле может быть null
    private Position position; //Поле может быть null
    private Status status; //Поле может быть null
    private Organization organization; //Поле не может быть null

    public String getOwner() {
        return owner;
    }

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

    public LocalDate getEndDate() {
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

    public Coordinates setCoordinates(Coordinates coordinates) {
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


    public static Double setSalary() {

        System.out.print("Input salary:\n>>");
        boolean flag = false;
        String st=new Scanner(System.in).nextLine().trim();
        double salary=0D;
        try {
            salary = Double.parseDouble(st);
        } catch (InputMismatchException |NumberFormatException ex) {
            flag = true;
        }

        while (salary <= 0||flag||st.equals("")) {
            flag=false;
            System.out.print("!!!Input salary again!!!(Salary must be more than 0)\n>>");
            try {
                st=new Scanner(System.in).nextLine().trim();
                salary = Double.parseDouble(st);
            } catch (InputMismatchException|NumberFormatException ex) {
                flag = true;
            }
        }
        return salary;
    }

    public static Position setPosition() {
        Position position=null;
        boolean flag=false;
        System.out.print("Input position\n>>");
        String pos=new Scanner(System.in).nextLine().trim();
        if(pos.equals(""))return null;
        try {
            position = Position.valueOf(pos);
        } catch (IllegalArgumentException ex) {
            flag = true;
        }
        while (position == null || flag) {
            flag = false;
            System.out.print("!!!Input position again!!!(Position takes one of the values:\nMANAGER,\nHEAD_OF_DIVISION,\nDEVELOPER,\nBAKER,\nCLEANER\n>>");
            pos=new Scanner(System.in).nextLine().trim();
            if(pos.equals(""))return null;
            try {
                position = Position.valueOf(pos);
            } catch (IllegalArgumentException ex) {
                flag = true;
            }
        }
        return position;
    }

    public static Status setStatus() {
        Status status=null;
        boolean flag=false;
        System.out.print("Input status\n>>");
        String pos=new Scanner(System.in).nextLine().trim();
        if(pos.equals(""))return null;
        try {
            status = Status.valueOf(pos);
        } catch (IllegalArgumentException ex) {
            flag = true;
        }
        while (status == null || flag) {
            flag = false;
            System.out.print("!!!Input status again!!!(Status takes one of the values:\nFIRED,\nRECOMMENDED_FOR_PROMOTION,\nREGULAR;>>");
            pos=new Scanner(System.in).nextLine().trim();
            if(pos.equals(""))return null;
            try {
                status = Status.valueOf(pos);
            } catch (IllegalArgumentException ex) {
                flag = true;
            }
        }
        return status;
    }

    public Worker cur(){
        return this;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public static LocalDate setEndDate() {
        System.out.print("Input endDate in format yyyy-mm-dd\n>>");
        boolean flag=false;
        LocalDate endDate=null;
        String st=new Scanner(System.in).nextLine();
        if(st.equals(""))return null;
        try {
            endDate=LocalDate.parse(st);
        }catch(Exception e){
            flag=true;
        }
        while (flag) {
            flag=false;
            System.out.print("!!!Error!!! Try again in format yyyy-mm-dd\n>>");
            st=new Scanner(System.in).nextLine();
            if(st.equals(""))return null;
            try {
                endDate=LocalDate.parse(st);
            }catch(Exception e){
                flag=true;
            }
        }
        return endDate;
    }

    public boolean moreThan(Worker worker) {
        if (worker.position == null)
            return false;
        if (this.position == null)
            return true;
        return (this.position.getPs() > worker.position.getPs()) || (this.position.getPs() == worker.position.getPs() && this.salary > worker.salary);
    }


    public Worker(String name, Coordinates coordinates, double salary, Status status, Organization organization) {
        this.name = setName(name);
        this.coordinates = setCoordinates(coordinates);

        this.salary = salary;
        this.status = status;
        this.organization =organization;
    }


    public Worker(String name, Coordinates coordinates, double salary, Organization organization) {
        this.name = setName(name);
        this.coordinates = setCoordinates(coordinates);
        this.salary = salary;
        this.organization = organization;

    }
    public Worker(String name, Coordinates coordinates, double salary, Position position, Status status, Organization organization) {
        this.name = setName(name);
        this.coordinates = setCoordinates(coordinates);
        this.salary = salary;
        this.name = name;
        this.position = position;
        this.status = status;
        this.organization = organization;
    }

    public Worker(String name, Coordinates coordinates, Date creationDate, double salary, LocalDate endDate, Position position, Status status, Organization organization) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.endDate = endDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
    }

    public Worker(String name, Coordinates coordinates, double salary, LocalDate endDate, Position position, Status status, Organization organization) {
        this.name = name;
        this.coordinates = coordinates;
        this.salary = salary;
        this.endDate = endDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
    }

    public Worker(String name, Coordinates coordinates, double salary, LocalDate endDate, Position position, Status status, Organization organization, String user) {
        this.name = name;
        this.coordinates = coordinates;
        this.salary = salary;
        this.endDate = endDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
        this.owner=user;
    }


    public Worker(String name, Coordinates coordinates, Date creationDate, double salary, LocalDate endDate, Position position, Status status, Organization organization, String user) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.endDate = endDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
        this.owner = user;
    }

    public Worker(String owner, String name, Coordinates coordinates, double salary, Organization organization) {
        this.owner = owner;
        this.name = name;
        this.coordinates = coordinates;
        this.salary = salary;
        this.organization = organization;
    }

    public Worker(String owner, String name, Coordinates coordinates, double salary, Status status, Organization organization) {
        this.owner = owner;
        this.name = name;
        this.coordinates = coordinates;
        this.salary = salary;
        this.status = status;
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", salary=" + salary +
                ", endDate=" + endDate +
                ", position=" + position +
                ", status=" + status +
                ", organization=" + organization +
                '}';
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Worker(String name) {
        this.name = name;
    }

}