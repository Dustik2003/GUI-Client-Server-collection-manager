package client.GUI;

import worker.Position;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class PositionCellEditor extends AbstractCellEditor implements TableCellEditor {

    int row,column;
    public   JComboBox<Position> position = new JComboBox<>(new Position[]{
            null,
            Position.CLEANER,
            Position.BAKER,
            Position.DEVELOPER, Position.HEAD_OF_DIVISION, Position.MANAGER
    });

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row=row;
        this.column=column;
        return position;
    }

    @Override
    public Object getCellEditorValue() {
        int indPos= position.getSelectedIndex();
        Position pos=indPos<0?null:Position.values()[indPos-1];
        WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "")).setPosition(pos);
        return pos;
    }
}
