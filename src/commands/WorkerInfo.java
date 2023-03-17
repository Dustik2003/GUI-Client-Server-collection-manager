package commands;

import worker.Worker;

import javax.swing.*;
import java.awt.*;

public class WorkerInfo extends JFrame {



    public WorkerInfo(Worker worker) throws HeadlessException {
        setTitle(worker.getName());
        setBounds(100,200,300,200);
        setResizable(false);
        setLayout(new GridLayout(9,1));
        JLabel owner=new JLabel("Owner: "+worker.getOwner());
        JLabel name=new JLabel("Name: "+worker.getName());
        JLabel coordinates=new JLabel("Coordinates: "+worker.getCoordinates());
        JLabel date=new JLabel("Creation date: "+worker.getCreationDate());
        JLabel salary=new JLabel("Salary: "+worker.getSalary());
        JLabel endDate=new JLabel("End date: "+worker.getEndDate());
        JLabel position=new JLabel("Position: "+worker.getPosition());
        JLabel status=new JLabel("Status: "+worker.getStatus());
        JLabel org=new JLabel("Organization: "+worker.getOrganization());
        this.add(owner);
        this.add(name);
        this.add(coordinates);
        this.add(date);
        this.add(salary);
        this.add(endDate);
        this.add(position);
        this.add(status);
        this.add(org);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
