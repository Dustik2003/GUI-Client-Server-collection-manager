package client.GUI;

import client.GuiClient;
import commands.ChangeWorker;
import worker.Coordinates;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.io.IOException;

public class FloatCellEditor extends AbstractCellEditor implements TableCellEditor {
    int row,column;
    JTextField textField;
    String curVal;

    public FloatCellEditor() {
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
            Float.valueOf(textField.getText()+"");
        }catch (Exception e) {
            return Float.parseFloat(curVal);
        }
        float num = Float.parseFloat(textField.getText()+"");
        long id=Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "");
        Coordinates coordinates = WorkersTable.workers.get(id).getCoordinates();
        coordinates.setX(num);
        WorkersTable.workers.get(id).setCoordinates(coordinates);
        WorkersTable.getTable().getModel().setValueAt(num, row, column);
        try {
            GuiClient.sendObj(new ChangeWorker(id,num,column));
            GuiClient.getObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return num;
    }
}
