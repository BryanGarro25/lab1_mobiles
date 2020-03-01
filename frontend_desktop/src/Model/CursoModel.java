/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessLogic.Curso;

/**
 *
 * @author Josue
 */
public class CursoModel extends java.util.Observable {

    Curso current;
    int modo;

    public CursoModel() {

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
    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    } 

    public Curso getCurrent() {
        return current;
    }

    public void setCurrent(Curso current) {
        this.current = current;
    }
    
}
