package worker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Organization implements Validatable {
    private Integer employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле не может быть null


    public Organization(Integer employeesCount, OrganizationType type) {
        this.employeesCount = employeesCount;
        this.type = type;
    }

    public static Integer setEmployeesCount() {
        Integer x = null;
        boolean flag = false;
        System.out.print("Input employees count:\n>>");
        try {
            x = new Scanner(System.in).nextInt();
        } catch (InputMismatchException ex) {
            flag = true;
        }
        while (x == null || flag) {
            flag = false;
            System.out.print("!!!Input employees count again!!!(Employees must be more than 0)\n>>");
            try {
                x = new Scanner(System.in).nextInt();
            } catch (InputMismatchException ex) {
                flag = true;
            }
        }
        return x;
    }


    public static OrganizationType setType() {
        OrganizationType type = null;
        boolean flag = false;
        System.out.print("Input organization type\n>>");
        try {
            type = OrganizationType.valueOf(new Scanner(System.in).nextLine());
        } catch (IllegalArgumentException ex) {
            flag = true;
        }
        while (type == null || flag) {
            flag = false;
            System.out.print("!!!Input organization type again!!!(OrganizationType takes one of the values:\nGOVERNMENT,\nTRUST,\nOPEN_JOINT_STOCK_COMPANY)\n>>");
            try {
                type = OrganizationType.valueOf(new Scanner(System.in).nextLine());
            } catch (IllegalArgumentException ex) {
                flag = true;
            }
        }
        return type;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public OrganizationType getType() {
        return type;
    }

    @Override
    public boolean validate() {
        return this.employeesCount != null && this.type != null && this.employeesCount > 0;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "employeesCount=" + employeesCount +
                ", type=" + type +
                '}';
    }
}