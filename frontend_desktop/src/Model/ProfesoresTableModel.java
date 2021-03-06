/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessLogic.Profesor;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Josue
 */
public class ProfesoresTableModel extends AbstractTableModel {

    List<Profesor> rows;
    int[] cols;

    public ProfesoresTableModel(int[] cols, List<Profesor> rows) {
        this.cols = cols;
        this.rows = rows;
        initColNames();
    }

    @Override
    public String getColumnName(int col) {

        return colNames[cols[col]];
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    public List<Profesor> getRows() {
        return rows;
    }

    
    @Override
    public Object getValueAt(int row, int col) {
        Profesor profe = rows.get(row);
        switch (cols[col]) {
            case CEDULA:
                return profe.getCedula();
            case NOMBRE:
                return profe.getNombre();
            case TELEFONO:
                return profe.getTelefono();
            case EMAIL:
                return profe.getEmail();
            default:
                return "";
        }
    }

    private Icon getIcon() {
        return new ImageIcon( getClass().getResource( "/Presentation/Icons/edit.png" ) );
    }
    String[] colNames = new String[4];

    private void initColNames() {
        colNames[CEDULA] = "Cedula";
        colNames[NOMBRE] = "Nombre";
        colNames[TELEFONO] = "Telefono";
        colNames[EMAIL] = "Email";
    }
    public static final int CEDULA = 0;
    public static final int NOMBRE = 1;
    public static final int TELEFONO = 2;
    public static final int EMAIL = 3;

    @Override
    public int getColumnCount() {
        return cols.length;
    }
}
