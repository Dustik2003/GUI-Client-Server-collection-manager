package client.GUI;

import worker.Organization;

import java.util.Comparator;

public class SortByOrganization implements Comparator<Organization> {
    @Override
    public int compare(Organization o1, Organization o2) {
        if(o1.getType().equals(o2.getType())){
            return o1.getEmployeesCount()-o2.getEmployeesCount();
        }
        return o1.getType().compareTo(o2.getType());
    }
}
