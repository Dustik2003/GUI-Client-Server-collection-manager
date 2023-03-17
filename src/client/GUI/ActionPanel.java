package client.GUI;

import client.GuiClient;
import com.sun.tools.javac.Main;
import commands.Update;
import worker.Worker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashMap;

public class ActionPanel {
    private static JPanel jPanel=null;
    static String user;
    public static JPanel getActionPanel(String owner){
        if(jPanel==null){
            user=owner;
            jPanel=new JPanel();
            JButton insert=new JButton("insert");
            JButton update=new JButton("update");
            JButton remove=new JButton("remove");
//            JButton removeGreater=new JButton("remove greater key");
//            JButton clear=new JButton("clear");
            JButton replaceIfGreater=new JButton("replace if greater");
//            JButton history=new JButton("history");
            insert.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new WorkerLoader(true,user);
                }
            });
            update.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        GuiClient.sendObj(new Update());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    WorkersTable.setjTable(null);
                    try {
                        WorkersTable.workers=(LinkedHashMap<Long, Worker>)GuiClient.getObject();
                        MainWindow.panel.remove(MainWindow.panel.getComponentCount()-1);
                        MainWindow.panel.add(new JScrollPane(WorkersTable.getTable()));
                        ((JPanel)MainWindow.panel).updateUI();
                        System.out.println("qwertyu");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            replaceIfGreater.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new WorkerLoader(null,user);
                }
            });
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ArgSetter(true);
                }
            });
//            removeGreater.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    new ArgSetter(false);
//                }
//            });






            jPanel.add(insert);
            jPanel.add(update);
            jPanel.add(remove);
//            jPanel.add(removeGreater);
//            jPanel.add(history);
            jPanel.add(replaceIfGreater);
//            jPanel.add(clear);
            jPanel.setVisible(true);
        }
        return jPanel;
    }
}
