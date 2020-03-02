/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BusinessLogic.Profesor;
import Controllers.Control;
import Model.ProfesorModel;
import Presentation.ProfesorView;
import frontend_desktop.Frontend_desktop;

/**
 *
 * @author Josue
 */
public class ProfesorController {

    Control domainModel;
    ProfesorView view;
    ProfesorModel model;

    public ProfesorController(Control domainModel, ProfesorView view, ProfesorModel model) {
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        this.view.setController(this);
        this.view.setModel(model);

    }

    public void show() {
        view.setVisible(true);
        this.setModo();

    }

    public void setModo() {
        model.setModo(Frontend_desktop.MODO_AGREGAR);
    }

    public int guardar(Profesor profesor) throws Exception {
        int result = 0;
        switch (model.getModo()) {
            case Frontend_desktop.MODO_AGREGAR:
                result = domainModel.insertarProfesor(profesor);
                Frontend_desktop.PROFESORES_CONTROLLER.refrescarBusqueda();
                model.setCurrent(new Profesor());
                this.hide();
                model.commit();
                break;
            case Frontend_desktop.MODO_EDITAR:
                result = domainModel.modificarProfesor(profesor);
                Frontend_desktop.PROFESORES_CONTROLLER.refrescarBusqueda();
                model.setModo(Frontend_desktop.MODO_AGREGAR);
                model.setCurrent(new Profesor());
                model.commit();
                this.hide();
                break;
        }
        return result;
    }

    public void hide() {
        model.setCurrent(new Profesor());
        view.setVisible(false);
    }

    public void reset(int modo, Profesor profesor) {
        this.model.setModo(modo);
        this.model.setCurrent(profesor);
        this.model.commit();
        //this.view.setVisible(true);
    }
}
