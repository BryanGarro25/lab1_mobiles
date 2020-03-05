/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessLogic.Curso;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Josue
 */
public class CursosTableModel extends AbstractTableModel {

    List<Curso> rows;
    int[] cols;

    public CursosTableModel(int[] cols, List<Curso> rows) {
        this.cols = cols;
        this.rows = rows;
        initColNames();
    }

    public List<Curso> getRows() {
        return rows;
    }
    
    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int col) {
        return colNames[cols[col]];
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Curso curso = rows.get(row);
        switch (cols[col]) {
            case CODIGO:
                return curso.getCodigo();
            case NOMBRE:
                return curso.getNombre();
            case CREDITOS:
                return curso.getCreditos();
            case HORAS:
                return curso.getHorasSemanales();

            default:
                return "";
        }
    }

    /*private Icon getIcon() {
        return new ImageIcon( getClass().getResource( "/Presentation/Icons/edit.png" ) );
    }*/
    String[] colNames = new String[4];

    private void initColNames() {
        colNames[CODIGO] = "Código";
        colNames[NOMBRE] = "Nombre";
        colNames[CREDITOS] = "Creditos";
        colNames[HORAS] = "Horas";

    }
    public static final int CODIGO = 0;
    public static final int NOMBRE = 1;
    public static final int CREDITOS = 2;
    public static final int HORAS = 3;

}
