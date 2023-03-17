package client.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            JButton removeGreater=new JButton("remove greater key");
            JButton clear=new JButton("clear");
            JButton replaceIfGreater=new JButton("replace if greater");
            JButton history=new JButton("history");
            insert.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new WorkerLoader(true,user);
                }
            });
            update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new WorkerLoader(false,user);
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
            removeGreater.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ArgSetter(false);
                }
            });






            jPanel.add(insert);
            jPanel.add(update);
            jPanel.add(remove);
            jPanel.add(removeGreater);
            jPanel.add(history);
            jPanel.add(replaceIfGreater);
            jPanel.add(clear);
            jPanel.setVisible(true);
        }
        return jPanel;
    }
}
