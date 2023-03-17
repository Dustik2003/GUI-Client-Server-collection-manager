package client.GUI;

import worker.Coordinates;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

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

        Coordinates coordinates = WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "")).getCoordinates();
        coordinates.setX(num);
        WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "")).setCoordinates(coordinates);
        return num;
    }
}
