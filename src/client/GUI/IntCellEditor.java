package client.GUI;

import client.GuiClient;
import commands.ChangeWorker;
import worker.Coordinates;
import worker.Organization;
import worker.OrganizationType;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;

public class IntCellEditor extends AbstractCellEditor implements TableCellEditor {

    int row, column;
    JTextField textField;
    String curVal;
    public IntCellEditor() {
        this.textField = new JTextField();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        this.column = column;
        curVal=value + "";
        textField.setText(curVal);
        return textField;
    }

    @Override
    public Object getCellEditorValue() {
        try {
            Integer.valueOf(textField.getText() + "");
        } catch (Exception e) {
            return Integer.parseInt(curVal);
        }
        int num = Integer.parseInt(textField.getText());
        Organization org=WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "")).getOrganization();
        org.setEmployeesCount(num);
        WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "")).setOrganization(org);
        WorkersTable.getTable().getModel().setValueAt(num, row, column);
        try {
            GuiClient.sendObj(new ChangeWorker(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + ""),num,column));
            GuiClient.getObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(WorkersTable.workers);
        return num;
    }
}
