package client.GUI;

import worker.FileReader;
import worker.MapWorker;
import worker.Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class MainWindow{
    JFrame jFrame;
    static  JTabbedPane pane;
    String owner;
    static LinkedHashMap<Long,Worker> workers;
    public MainWindow(String owner){
        this.owner=owner;
        this.jFrame=new JFrame("Ashalet");
        this.pane=new JTabbedPane();
        JPanel panel2=new JPanel();
        Container panel=new JFrame().getContentPane();
//        FileReader.readFile("output.csv");
//        new MapWorker();
        Container header =new JFrame().getContentPane();
        header.setVisible(true);
        header.setLayout(new GridLayout(3,1));
        header.setSize(new Dimension(100,60));
        JPanel languages=new JPanel();
        languages.add(new JLabel("Languages: "));
        String[] items = {
                "Русский",
                "Norsk",
                "Български",
                "Español"
        };
        JComboBox comboBox = new JComboBox(items);
        languages.add(comboBox);
        JPanel tmp=new JPanel();
        tmp.add(new JLabel("User: "+owner),BorderLayout.WEST);
        tmp.add(languages,BorderLayout.EAST);
        tmp.setVisible(true);
        header.add(tmp);
//        header.add();
        header.add(ActionPanel.getActionPanel(owner));
        header.add(new FiltersPanel().getjPanel(),BorderLayout.SOUTH);
        panel.add(header,BorderLayout.NORTH);
//        this.jFrame.add(new JButton("qwertyui"));
        WorkersTable.workers=workers;
        panel.add(new JScrollPane(WorkersTable.getTable()));
//        this.jFrame.setBounds(500,500,700,700);
        panel.setVisible(true);
        pane.addTab("Table",panel);
//        Animation animation=new Animation();
//        animation.start();
        pane.addTab("Pizdec",new WorkersVisual());



        this.jFrame.setMinimumSize(new Dimension(700,400));
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.add(pane);
        this.jFrame.setVisible(true);
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int item =  ((JComboBox)e.getSource()).getSelectedIndex();
                System.out.println(item);
            }
        };



        comboBox.addActionListener(actionListener);

    }

}
