package gui;
import javax.swing.table.*;
import javax.swing.*;
import logic.PhilConst;
public class MyTableModel extends AbstractTableModel {
final String[] columnNames = {"Имя", "Голоден", "Состояние"}; final Object[][] data = {
            {PhilConst.names[0], new Boolean(false), PhilConst.stateMap[0]},
            {PhilConst.names[1], new Boolean(false), PhilConst.stateMap[0]},
            {PhilConst.names[2], new Boolean(false), PhilConst.stateMap[0]},
            {PhilConst.names[3], new Boolean(false), PhilConst.stateMap[0]},
            {PhilConst.names[4], new Boolean(false), PhilConst.stateMap[0]}
};
    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        return data.length;
}
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Object getValueAt(int row, int col) {
        return data[row][col];
}
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
}
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col == 1)
return true;
        return false;
    }
    public void setValueAt(Object value, int row, int col) {
        if (data[0][col] instanceof Integer
                && !(value instanceof Integer)) {
            try {
                data[row][col] = new Integer(value.toString());
                fireTableCellUpdated(row, col);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                    "The \"" + getColumnName(col)
                    + "\" column accepts only integer values.");
}
} else {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
} }