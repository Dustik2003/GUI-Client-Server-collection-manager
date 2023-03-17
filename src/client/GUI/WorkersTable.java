package client.GUI;

import worker.*;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.PatternSyntaxException;

import static client.GUI.Verifiers.doubleVerifier;
import static client.GUI.WorkerLoader.*;

public class WorkersTable {
    private static JTable jTable=null;
    static String owner="Loginity";
    public static LinkedHashMap<Long,Worker> workers;


    public static TableRowSorter<TableModel> sorter;
    public static JTable getTable(){
        if(jTable==null){
            DefaultTableModel model=new DefaultTableModel(){


                @Override
                public boolean isCellEditable(int i, int i1) {
                    return (owner.equals(this.getValueAt(i,0 ).toString()) && i1!=5 && i1>1 );
                }

            };
            Object[][] data = new Object[workers.size()][12];

            int i = 0;
            for (Long id : workers.keySet()) {
                Worker worker = workers.get(id);
                Object[] tmp = new Object[12];
                tmp[0] = worker.getOwner();
                tmp[1] = id;
                tmp[2] = worker.getName();
                tmp[3] = worker.getCoordinates().getX();
                tmp[4] = worker.getCoordinates().getY();
                tmp[5] = convertToLocalDateViaSqlDate(worker.getCreationDate());
                tmp[6] = worker.getSalary();
                tmp[7] = (LocalDate)worker.getEndDate();
                tmp[8] = worker.getPosition();
                tmp[9] = worker.getStatus();
                tmp[10] = worker.getOrganization().getEmployeesCount();
                tmp[11] = worker.getOrganization().getType();
                data[i] = (tmp);
                i++;
            }
            Object[] tmp = new Object[12];
            tmp[0] = ("owner");
            tmp[1] = ("id");
            tmp[2] = ("name");
            tmp[3] = ("coor-x");
            tmp[4] = ("coor-y");
            tmp[5] = ("creation_date");
            tmp[6] = ("salary");
            tmp[7] = ("end_date");
            tmp[8] = ("position");
            tmp[9] = ("status");
            tmp[10] = ("org-employesscount");
            tmp[11] = ("org-organization type");
            model.setColumnIdentifiers(tmp);
            for(int k=0;k< data.length;k++){
                model.addRow(data[k]);
            }
            jTable = new JTable(model);



//            DateFormatter dateFormatter=new DateFormatter(new SimpleDateFormat("yyyy-mm-dd"));
//
//            jTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(new JFormattedTextField(new SimpleDateFormat("yyyy-mm-dd"))));
            JTextField salary = new JTextField();
            salary.setInputVerifier(doubleVerifier);

            jTable.getColumnModel().getColumn(3).setCellEditor(new FloatCellEditor());
            jTable.getColumnModel().getColumn(4).setCellEditor(new DoubleCellEditor());
            jTable.getColumnModel().getColumn(6).setCellEditor(new DoubleCellEditor());
            jTable.getColumnModel().getColumn(7).setCellEditor(new DateCellEditor());
            jTable.getColumnModel().getColumn(8).setCellEditor(new PositionCellEditor());
            jTable.getColumnModel().getColumn(9).setCellEditor(new StatusCellEditor());
            jTable.getColumnModel().getColumn(10).setCellEditor(new IntCellEditor());
            jTable.getColumnModel().getColumn(11).setCellEditor(new OrganizationTypeCellEditor());


            sorter=new TableRowSorter<>(jTable.getModel());
            sorter.setComparator(1,new SortById());
            sorter.setComparator(3,new SortByFloat());
            sorter.setComparator(4,new SortByDouble());
            sorter.setComparator(7, new Comparator<LocalDate>() {
                @Override
                public int compare(LocalDate o1, LocalDate o2) {
                    return o1.compareTo(o2);
                }
            });
            sorter.setComparator(6,new  SortByDouble());
            sorter.setComparator(7, new Comparator<LocalDate>() {
                @Override
                public int compare(LocalDate o1, LocalDate o2) {
                    return o1.compareTo(o2);
                }
            });
            sorter.setComparator(8, new Comparator<Position>() {
                @Override
                public int compare(Position o1, Position o2) {
                    return o1.compareTo(o2);
                }
            });
            sorter.setComparator(9, new Comparator<Status>() {
                @Override
                public int compare(Status o1, Status o2) {
                    return o1.compareTo(o2);
                }
            });
            sorter.setComparator(10, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });

            sorter.setComparator(11,new Comparator<OrganizationType>(){
                @Override
                public int compare(OrganizationType o1, OrganizationType o2) {
                    return o1.compareTo(o2);
                }
            });
            jTable.setRowSorter(sorter);

        }
        return jTable;
    }


    public static LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public static void setWorkers(LinkedHashMap<Long, Worker> workers) {
        WorkersTable.workers = workers;
    }

}
