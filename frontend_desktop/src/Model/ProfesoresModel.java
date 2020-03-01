/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessLogic.Profesor;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 *
 * @author Josue
 */
public class ProfesoresModel extends java.util.Observable {

    Profesor filter;
    ProfesoresTableModel profesores;
    Profesor seleccionado;

    public ProfesoresModel() {
        this.reset();
    }

    private void reset() {
        filter = new Profesor();
        List<Profesor> rows = new ArrayList<>();
        seleccionado = null;
        this.setProfesores(rows);
        this.commit();
    }

    public void setProfesores(List<Profesor> profesores) {
        int[] cols = {ProfesoresTableModel.CEDULA, ProfesoresTableModel.NOMBRE, ProfesoresTableModel.TELEFONO, ProfesoresTableModel.EMAIL, ProfesoresTableModel.MODIFICAR};
        this.profesores = new ProfesoresTableModel(cols, profesores);
    }

    public void commit() {
        setChanged();
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        this.commit();
    }

    public ProfesoresTableModel getProfesores() {
        return profesores;
    }
}
