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
                // model.setCurrent(new Funcionario());
                model.commit();
                break;
            /* case Application.MODO_EDITAR:
                domainModel.updateFuncionario(funcionario);
                Application.FUNCIONARIOS_CONTROLLER.refrescarBusqueda();               
                break;*/
        }
        return result;
    }
    public void hide(){
        view.setVisible(false);
    }
}
