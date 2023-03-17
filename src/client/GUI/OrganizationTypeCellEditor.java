package client.GUI;

import worker.Organization;
import worker.OrganizationType;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class OrganizationTypeCellEditor extends AbstractCellEditor implements TableCellEditor {

    int row,column;

    public   JComboBox<OrganizationType> orgType = new JComboBox<>(new OrganizationType[]{
            OrganizationType.TRUST,
            OrganizationType.OPEN_JOINT_STOCK_COMPANY,
            OrganizationType.GOVERNMENT}
    );

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row=row;
        this.column=column;
        return orgType;
    }

    @Override
    public Object getCellEditorValue() {
        int type= orgType.getSelectedIndex();
        OrganizationType ot=OrganizationType.values()[type];
        Organization org=WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "")).getOrganization();
        org.setType(ot);
        WorkersTable.workers.get(Long.parseLong(WorkersTable.getTable().getValueAt(row, 1) + "")).setOrganization(org);
        return ot;
    }
}