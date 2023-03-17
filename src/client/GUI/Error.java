package client.GUI;

import javax.swing.*;
import java.awt.*;

public class Error extends JFrame {
    String txt;

    public Error(String txt) throws HeadlessException {
        setTitle("ERROR");
        this.txt=txt;
        JLabel label=new JLabel(txt);
        setBounds(300,300,txt.length()*7,100);
        add(label);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
