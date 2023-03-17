package client.GUI;

import worker.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Pattern;

import static client.GUI.Verifiers.*;
import static java.lang.Thread.sleep;

public class WorkerLoader {
    JFrame jFrame = new JFrame();
    Boolean act;
    String user;

    public   JComboBox<Position> position = new JComboBox<>(new Position[]{
            null,
            Position.CLEANER,
            Position.BAKER,
            Position.DEVELOPER, Position.HEAD_OF_DIVISION, Position.MANAGER
    });
    public JComboBox<Status> status = new JComboBox<>(new Status[]{
            null,
            Status.FIRED,
            Status.RECOMMENDED_FOR_PROMOTION,
            Status.REGULAR}
    );

    public   JComboBox<OrganizationType> orgType = new JComboBox<>(new OrganizationType[]{
            OrganizationType.TRUST,
            OrganizationType.OPEN_JOINT_STOCK_COMPANY,
            OrganizationType.GOVERNMENT}
    );
    public WorkerLoader(Boolean act,String user ) {
        this.act=act;
        this.user=user;
        jFrame.setTitle(act==null?"Replace if greater":(act ?"Insert":"Update"));
        JButton jButton = new JButton("Continue");

        JTextField id=new JTextField();
        JTextField name = new JTextField();
        JTextField xCoor = new JTextField();
        JTextField yCoor = new JTextField();
        JTextField salary = new JTextField();
        JTextField endDate = new JTextField();
        JTextField emCount = new JTextField();

//        name.setInputVerifier(nameVerifier);
        xCoor.setInputVerifier(doubleVerifier);
        yCoor.setInputVerifier(doubleVerifier);
        salary.setInputVerifier(doubleVerifier);
        emCount.setInputVerifier(intVerifier);
        endDate.setInputVerifier(dateVerifier);


        name.setPreferredSize(new Dimension(100, 20));
        xCoor.setPreferredSize(new Dimension(50, 20));
        yCoor.setPreferredSize(new Dimension(50, 20));
        salary.setPreferredSize(new Dimension(50, 20));
        endDate.setPreferredSize(new Dimension(50, 20));
        position.setPreferredSize(new Dimension(100, 20));
        status.setPreferredSize(new Dimension(100, 20));
        emCount.setPreferredSize(new Dimension(50, 20));
        orgType.setPreferredSize(new Dimension(100, 20));
        JPanel jPanel = new JPanel(new GridLayout(9,1,5,5));

        this.jFrame.setBounds(100, 200, 250, 330);
        if(act==null||!act){
            id.setInputVerifier(intVerifier);
            jPanel.setLayout(new GridLayout(10,1,5,5));
            jPanel.add(new Label("Id: "));

            this.jFrame.setSize(new Dimension(250,360));
            jPanel.add(id);
        }
        JPanel mainJPanel=new JPanel();
        jPanel.add(new Label("name: "));
        jPanel.add(name);
        jPanel.add(new Label("coordinates.x: "));
        jPanel.add(xCoor);
        jPanel.add(new Label("coordinates.y: "));
        jPanel.add(yCoor);
        jPanel.add(new Label("salary: "));
        jPanel.add(salary);
        jPanel.add(new Label("end date: "));
        jPanel.add(endDate);
        jPanel.add(new Label("position: "));
        jPanel.add(position);
        jPanel.add(new Label("status: "));
        jPanel.add(status);
        jPanel.add(new Label("employees count: "));
        jPanel.add(emCount);
        jPanel.add(new Label("organization type: "));
        jPanel.add(orgType);
        mainJPanel.add(jPanel);
        mainJPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(endDate.getText()+"   1   23");
                if(name.getText().equals("")||xCoor.getText().equals("")||yCoor.getText().equals("")||(salary.getText()).equals("") ||Double.parseDouble(salary.getText())<1||(emCount.getText()).equals("") ||Integer.parseInt(salary.getText())<1){
                    Runnable runnable=new Runnable() {
                        @Override
                        public void run() {
                            Error error=new Error("Not all field was entered");
                            try {
                                sleep(3000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            error.setVisible(false);
                        }
                    };
                    new Thread(runnable).start();
                    return;
                }

                LocalDate date=null;
                try{ date=LocalDate.parse(endDate.getText());
                }catch (Exception exception){
                    date=null;
                }
                LocalDate finalDate = date;
                int indPos=position.getSelectedIndex()>0?position.getSelectedIndex()-1:position.getSelectedIndex()+1;
                int indStat=status.getSelectedIndex()>0?status.getSelectedIndex()-1:status.getSelectedIndex()+1;
                Position tmpPos=indPos>=0?Position.values()[indPos]:null;
                Status tmpStat=indStat>=0?Status.values()[indStat]:null;
                System.out.println("pos  "+indPos);
                System.out.println("stat  "+indStat);
                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        Worker worker=new Worker(name.getText(),new Coordinates(Float.parseFloat(xCoor.getText()),Double.parseDouble(yCoor.getText())),Double.parseDouble(salary.getText()), finalDate,tmpPos,tmpStat,new Organization(Integer.parseInt(emCount.getText()),OrganizationType.values()[orgType.getSelectedIndex()]),user);
                        if(Boolean.TRUE.equals(act)){
                            MapWorker.getWorkers().put(++MapWorker.id,worker);
                            DefaultTableModel model= (DefaultTableModel) WorkersTable.getTable().getModel();
                            model.addRow(new Object[]{worker.getOwner(),MapWorker.id,worker.getName(),worker.getCoordinates().getX(),worker.getCoordinates().getX(),convertToLocalDateViaInstant( worker.getCreationDate()),worker.getSalary(),worker.getEndDate(),worker.getPosition(),worker.getStatus(),worker.getOrganization().getEmployeesCount(),worker.getOrganization().getType()});


                        }
                        else{
                            if(MapWorker.getWorkers().keySet().contains(Long.parseLong(id.getText()))){
                                if(MapWorker.getWorkers().get(Long.parseLong(id.getText())).getOwner().equals(user)){
                                    if (!worker.moreThan(MapWorker.getWorkers().get(Long.parseLong(id.getText())))){
                                        System.out.println("qwert");
                                        MapWorker.getWorkers().replace(Long.parseLong(id.getText()),worker);
                                        int k=0;
                                        for(Long num: MapWorker.workers.keySet()){
                                            if(WorkersTable.getTable().getValueAt(k,1).equals(Long.parseLong(id.getText()))) {

                                                WorkersTable.getTable().getModel().setValueAt(worker.getOwner(), k, 0);
                                                WorkersTable.getTable().getModel().setValueAt(worker.getName(), k, 2);
                                                WorkersTable.getTable().getModel().setValueAt(worker.getCoordinates().getX(), k,3);
                                                WorkersTable.getTable().getModel().setValueAt(worker.getCoordinates().getY(), k,4);
                                                WorkersTable.getTable().getModel().setValueAt(convertToLocalDateViaInstant(worker.getCreationDate()), k, 5);
                                                WorkersTable.getTable().getModel().setValueAt(worker.getSalary(), k, 6);
                                                WorkersTable.getTable().getModel().setValueAt(worker.getEndDate(), k, 7);
                                                WorkersTable.getTable().getModel().setValueAt(worker.getPosition(), k, 8);
                                                WorkersTable.getTable().getModel().setValueAt(worker.getStatus(), k, 9);
                                                WorkersTable.getTable().getModel().setValueAt(worker.getOrganization().getEmployeesCount(), k, 10);
                                                WorkersTable.getTable().getModel().setValueAt(worker.getOrganization().getType(), k, 11);
//                                                WorkersTable.getTable().getModel().setValueAt(worker.get(), k, 0);
                                                return;
                                            }
                                            k++;
                                        }
                                    }
                                }
                            }
                        }



                    }
                };
                new Thread(runnable).start();




            }
        });
//        this.jFrame.setLayout(layout);
//        this.jFrame.add(jPanel);
        this.jFrame.add(mainJPanel);
        this.jFrame.setResizable(false);
        this.jFrame.setVisible(true);
        this.jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public WorkerLoader(){}
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
