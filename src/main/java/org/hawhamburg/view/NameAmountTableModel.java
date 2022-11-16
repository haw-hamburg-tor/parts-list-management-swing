package org.hawhamburg.view;

import javax.swing.table.AbstractTableModel;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class NameAmountTableModel extends AbstractTableModel {

    private static final List<String> COLUMN_NAMES = List.of("Name", "Amount");
    private Vector<String> names;
    private Vector<Integer> amounts;

    public NameAmountTableModel() {
        this.names = new Vector<>();
        this.amounts = new Vector<>();
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES.get(column);
    }

    @Override
    public int getRowCount() {
        return names.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> names.get(rowIndex);
            case 1 -> amounts.get(rowIndex);
            default -> null;
        };
    }

    public void addEntry(String name, Integer amount) {
        int changedRowIndex = getRowCount();
        names.add(name);
        amounts.add(amount);
        fireTableRowsInserted(changedRowIndex, changedRowIndex);
    }

    public void setEntries(Vector<String> names, Vector<Integer> amounts) {
        this.names = names;
        this.amounts = amounts;
        fireTableDataChanged();
    }

    public void removeAll() {
        names = new Vector<>();
        amounts = new Vector<>();
        fireTableDataChanged();
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }

    public List<Integer> getAmounts() {
        return Collections.unmodifiableList(amounts);
    }
}
