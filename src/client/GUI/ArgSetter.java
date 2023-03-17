package client.GUI;

import worker.OrganizationType;
import worker.Position;
import worker.Status;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import static client.GUI.Verifiers.intVerifier;

public class ArgSetter {
    JFrame jFrame = new JFrame();
    boolean act;
    public ArgSetter(boolean act) {
        this.act=act;
        this.jFrame.setTitle(act?"Remove":"Remove greater key");
        JTextField arg=new JTextField();
        JLabel label =new JLabel("Input id value: ");
        JButton jButton = new JButton("Continue");
        arg.setPreferredSize(new Dimension(60,20));
        arg.setInputVerifier(intVerifier);
        JPanel jPanel=new JPanel();
        jPanel.add(label);
        jPanel.add(arg);
        jPanel.add(jButton);
        this.jFrame.add(jPanel);
        this.jFrame.setVisible(true);
        this.jFrame.setResizable(false);
        this.jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.jFrame.setBounds(100, 200, 200, 100);
    }

}
