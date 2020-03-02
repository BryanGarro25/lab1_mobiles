/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessLogic.Profesor;
import frontend_desktop.Frontend_desktop;

/**
 *
 * @author Josue
 */
public class ProfesorModel extends java.util.Observable {

    Profesor current;
    int modo;

    public ProfesorModel() {
        this.reset();
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

    public void reset() {
        this.reset(Frontend_desktop.MODO_AGREGAR, new Profesor());
    }

    public void reset(int modo, Profesor current) {
        this.setModo(modo);
        this.setCurrent(current);
        this.commit();
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public Profesor getCurrent() {
        return current;
    }

    public void setCurrent(Profesor current) {
        this.current = current;
    }

}
