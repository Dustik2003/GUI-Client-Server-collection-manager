package client.GUI;

import client.GuiClient;
import client.LogAndPass;
import worker.MapWorker;
import worker.Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashMap;

public class RegistrationOrAuthorization {
    JFrame jFrame=new JFrame();
    boolean isReg;

    public RegistrationOrAuthorization(boolean isReg){
        jFrame.setTitle(isReg?"Registration":"Authorization");
        JButton jButton=new JButton("Continue");
        this.isReg=isReg;
        JTextField login=new JTextField();
        JPasswordField password=new JPasswordField();
        password.setPreferredSize(new Dimension(100,20));
        login.setPreferredSize(new Dimension(100,20));
        JPanel jPanel=new JPanel();
        jPanel.add(new Label("          Login          "));
        jPanel.add(login);
        jPanel.add(new Label("     Password       "));
        jPanel.add(password);
        jPanel.add(jButton);
        this.jFrame.setBounds(100,200,300,150);
        this.jFrame.add(jPanel);
        this.jFrame.setResizable(false);
        this.jFrame.setVisible(true);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String log=login.getText(), pass= String.valueOf(password.getPassword());
                if(log.length()<8 || log.length()>32||pass.length()<8||pass.length()>32){
                    new Error("Password or login length can't be shorter than 8 and longer than 32");
                }

                LogAndPass logAndPass=new LogAndPass(log,pass,isReg);
                try {
                    GuiClient.sendObj(logAndPass);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                boolean tmp = false;
                try {
                    tmp=(boolean) GuiClient.getObject();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                jFrame.setVisible(false);
                System.out.println(tmp );
                LinkedHashMap<Long,Worker> workers=null;
                try {GuiClient.sendObj("qwer");
                    workers=(LinkedHashMap<Long,Worker>) GuiClient.getObject();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println(workers);
                MainWindow.workers=workers;
                new MainWindow(log);


            }
        });
    }
}
