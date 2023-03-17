package client.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseRegAut{
    JFrame jFrame=new JFrame();
    public ChooseRegAut(){
        JLabel jLabel=new JLabel("For working with collection you must be logged in");
        JButton reg=new JButton("Registration");
        JButton aut=new JButton("Authorization");
        JPanel jPanel=new JPanel();
        jPanel.setSize(400,80);
        jPanel.add(jLabel);
        jPanel.add(reg);
        jPanel.add(aut);
        this.jFrame.add(jPanel);
        this.jFrame.setBounds(700,500,300,100);
        this.jFrame.setMinimumSize(new Dimension(350,100));
        this.jFrame.setResizable(false);
        this.jFrame.setVisible(true);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                RegistrationOrAuthorization registrationOrAuthorization=new RegistrationOrAuthorization(true);
            }
        });
        aut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                RegistrationOrAuthorization registrationOrAuthorization=new RegistrationOrAuthorization(false);
            }
        });


    }
}
