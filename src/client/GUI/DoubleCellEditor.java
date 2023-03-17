package client.GUI;

import client.GuiClient;
import commands.ChangeWorker;
import worker.Coordinates;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;

public class DoubleCellEditor extends AbstractCellEditor implements TableCellEditor {

    int row,column;
    JTextField textField;
    String curVal;

    public DoubleCellEditor() {
        this.textField =new JTextField();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row=row;
        this.column=column;
        curVal=value+"";
        textField.setText(curVal);
        return textField;
    }

    @Override
    public Object getCellEditorValue() {
        try{
            Double.valueOf(textField.getText()+"");
        }catch (Exception e) {
            return Double.parseDouble(curVal);
        }
        Double num=Double.valueOf(textField.getText());
        if(column==4) {
            Coordinates coordinates = WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "")).getCoordinates();
            coordinates.setY(num);
            WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "")).setCoordinates(coordinates);
        }
        else
            WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row,1)+"")).setSalary(num);
        WorkersTable.getTable().getModel().setValueAt(num, row, column);

        try {
            GuiClient.sendObj(new ChangeWorker(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + ""),num,column));
            System.out.println(GuiClient.getObject());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(WorkersTable.workers);
        return num;
    }
}
