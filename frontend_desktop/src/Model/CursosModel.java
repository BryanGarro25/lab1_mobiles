/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessLogic.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue
 */
public class CursosModel extends java.util.Observable {

    Curso filter;
    CursosTableModel cursos;
    Curso seleccionado;

    public CursosModel() {
        this.reset();
    }

    private void reset() {
        filter = new Curso();
        List<Curso> rows = new ArrayList<>();
        seleccionado = null;
        this.setCursos(rows);
        this.commit();
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        this.commit();
    }

    public void commit() {
        setChanged();
        notifyObservers();
    }

    public void setCursos(List<Curso> cursos) {
        int[] cols = {CursosTableModel.CREDITOS, CursosTableModel.HORAS,CursosTableModel.CODIGO, CursosTableModel.NOMBRE, };
        this.cursos = new CursosTableModel(cols, cursos);
    }

    public CursosTableModel getCursos() {
        return this.cursos;
    }
}
