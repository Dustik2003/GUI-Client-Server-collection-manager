package client.GUI;

import client.GuiClient;
import commands.ChangeWorker;
import worker.Position;
import worker.Status;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.io.IOException;

public class StatusCellEditor extends AbstractCellEditor implements TableCellEditor {

    int row,column;

    public JComboBox<Status> status = new JComboBox<>(new Status[]{
            null,
            Status.FIRED,
            Status.RECOMMENDED_FOR_PROMOTION,
            Status.REGULAR}
    );

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row=row;
        this.column=column;
        return status;
    }

    @Override
    public Object getCellEditorValue() {
        int indStat= status.getSelectedIndex();
        System.out.println(indStat);
        Status status=indStat<0?null:Status.values()[indStat-1];
        WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "")).setStatus(status);

        try {
            GuiClient.sendObj(new ChangeWorker(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + ""),status,column));

            GuiClient.getObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }
}