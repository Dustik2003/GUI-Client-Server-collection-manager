package client.GUI;

import worker.OrganizationType;
import worker.Position;
import worker.Status;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

import static client.GUI.Verifiers.doubleVerifier;
import static client.GUI.Verifiers.intVerifier;
import static client.GUI.WorkersTable.sorter;

public class FiltersPanel {
    public JPanel jPanel;


    public JPanel getjPanel() {
        jPanel = new JPanel();
        JButton button = new JButton("Filter");
        final Container[] field = {new JTextField()};
        field[0].setPreferredSize(new Dimension(200, 20));
        JComboBox<String> columnsHead = new JComboBox<>(new String[]{
                "owner",
                "id",
                "name",
                "coordinates_x",
                "coordinates_y",
                "creation_date",
                "salary",
                "end_date",
                "position",
                "status",
                "organization_employees-count",
                "organization_type"
        });


        jPanel.add(new JLabel("Filter by"));
        jPanel.add(columnsHead);
        jPanel.add(field[0]);
        jPanel.add(button);


        columnsHead.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int item =  ((JComboBox)e.getSource()).getSelectedIndex();
                jPanel.remove(jPanel.getComponentCount()-1);
                jPanel.remove(jPanel.getComponentCount()-1);
                System.out.println(item);
                switch (item) {
                    case(3):
                        field[0]=new JTextField();
                        ((JTextField)field[0]).setInputVerifier(doubleVerifier);
                        break;
                    case(4):
                        field[0]=new JTextField();
                        ((JTextField)field[0]).setInputVerifier(doubleVerifier);
                        break;
                    case(6):
                        field[0]=new JTextField();
                        ((JTextField)field[0]).setInputVerifier(doubleVerifier);
                        break;
                    case  (7):
                        DateFormatter dateFormatter=new DateFormatter(new SimpleDateFormat("yyyy-mm-dd"));
                        field[0] = new JFormattedTextField(dateFormatter);
                        break;
                    case  (8):
                        field[0] =new WorkerLoader().position;
                        break;
                    case (9):
                        field[0]=new WorkerLoader().status;
                        break;
                    case(10):
                        field[0]=new JTextField();
                        ((JTextField)field[0]).setInputVerifier(intVerifier);
                        break;
                    case (11):
                        field[0]=new WorkerLoader().orgType;
                        break;
                    default:
                        field[0]=new JTextField();
                }
                jPanel.add(field[0]);
                jPanel.add(button);
                field[0].setPreferredSize(new Dimension(200, 20));
                jPanel.updateUI();
            }
        });


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n=columnsHead.getSelectedIndex();
                Object text="";
                int tmp;
                switch (n) {
                    case  (3), (4):
                        text=((JTextField)field[0]).getText();
                        if(!text.equals(""))
                            if(!text.equals("")) {
                                try{
                                    text = Double.parseDouble(text + "");}
                                catch (NumberFormatException exc){
                                    text="";
                                }
                            }
                        System.out.println(text);
                        break;
                    case  (6):
                        text=((JTextField)field[0]).getText();
                        if(!text.equals("")) {
                            try{
                                text = Double.parseDouble(text + "");}
                            catch (NumberFormatException exc){
                                text="";
                            }
                        }
                        System.out.println(text);
                        break;
                    case  (7):
                        text=((JTextField)field[0]).getText();
                        System.out.println(text);
                        break;
                    case  (8):
                        tmp=((JComboBox<Position>)field[0]).getSelectedIndex()-1;
                        if(tmp>=0)
                            text=Position.values ()[(tmp)].toString();
                        break;
                    case (9):
                        tmp=((JComboBox<Status>)field[0]).getSelectedIndex()-1;
                        if(tmp>=0)
                            text=Status.values()[tmp].toString();
                        break;
                    case (10):
                        text=((JTextField)field[0]).getText();
                        if(!text.equals("")) {
                                try{
                                    text = (int)Double.parseDouble(text + "");}
                                catch (NumberFormatException exc){
                                    text="";
                                }
                            }
                        System.out.println(text);
                        break;
                    case (11):
                        tmp=((JComboBox<OrganizationType>)field[0]).getSelectedIndex();
                        text=OrganizationType.values()[(tmp)].toString();
                        break;
                    default:
                        field[0]=new JTextField();
                }
                if (text.toString().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    try {
                        System.out.println(text);

                        sorter.setRowFilter(RowFilter.regexFilter(text.toString(),n));
                    } catch (PatternSyntaxException pse) {
                        System.err.println("Bad regex pattern");
                    }
                }
            }
        });

        jPanel.setVisible(true);
        return jPanel;
    }

    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

}
