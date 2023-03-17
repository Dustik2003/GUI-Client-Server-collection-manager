package client.GUI;

import client.GuiClient;
import commands.ChangeWorker;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static client.GUI.Verifiers.dateVerifier;

class DateCellEditor extends AbstractCellEditor implements TableCellEditor {
    int row,column;

    // Редактор
    private JTextField textField;
    // Конструктор
    public DateCellEditor() {
        textField = new JTextField();
    }
    // Метод получения компонента для прорисовки
    public Component getTableCellEditorComponent(JTable table, Object value,boolean isSelected, int row, int column) {
        textField.setText(value+"");
        this.row=row;
        this.column=column;
        return  textField;
    }
    // Функция текущего значения в редакторе
    public Object getCellEditorValue() {
        try{
            LocalDate.parse(textField.getText());
        }catch (Exception e){
            WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row,1)+"")).setEndDate(null);
            WorkersTable.getTable().getModel().setValueAt(null, row, column);
            return null;}
        LocalDate date=LocalDate.parse(textField.getText());
        WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row,1)+"")).setEndDate(date);
        WorkersTable.getTable().getModel().setValueAt(date, row, column);

        try {
            GuiClient.sendObj(new ChangeWorker(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + ""),date,column));

            GuiClient.getObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return date;
    }
}