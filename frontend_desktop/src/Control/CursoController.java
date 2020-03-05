/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BusinessLogic.Curso;
import BusinessLogic.Profesor;
import Controllers.Control;
import Model.CursoModel;
import Presentation.CursoView;
import frontend_desktop.Frontend_desktop;

/**
 *
 * @author Josue
 */
public class CursoController {

    Control domainModel;
    CursoView view;
    CursoModel model;

    public CursoController(CursoView view, CursoModel model, Control domainModel) {
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

    public int guardar(Curso curso) throws Exception {
        int result = 0;
        switch (model.getModo()) {
            case Frontend_desktop.MODO_AGREGAR:
                result = domainModel.insertarCurso(curso);
                Frontend_desktop.CURSOS_CONTROLLER.refrescarBusqueda();
                model.setCurrent(new Curso());
                this.hide();
                model.commit();
                break;
            case Frontend_desktop.MODO_EDITAR:
                result = domainModel.modificarCurso(curso);
                Frontend_desktop.CURSOS_CONTROLLER.refrescarBusqueda();
                model.setModo(Frontend_desktop.MODO_AGREGAR);
                model.setCurrent(new Curso());
                this.hide();
                model.commit();
                break;
                  
        }
        return result;
    }

    public void hide() {
        view.setVisible(false);
    }

    public void reset(int modo, Curso curso) {
        this.model.setModo(modo);
        this.model.setCurrent(curso);
        this.model.commit();

    }
}
