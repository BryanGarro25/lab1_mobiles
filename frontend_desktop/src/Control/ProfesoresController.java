/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BusinessLogic.Curso;
import BusinessLogic.Profesor;
import Controllers.Control;
import Model.ProfesoresModel;
import Presentation.ProfesoresView;
import frontend_desktop.Frontend_desktop;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue
 */
public class ProfesoresController {

    Control domainModel;
    ProfesoresView view;
    ProfesoresModel model;

    public ProfesoresController(ProfesoresView view, ProfesoresModel model, Control domainModel) {
        this.view = view;
        this.model = model;
        this.domainModel = domainModel;
        view.setController(this);
        view.setModel(model);
    }

    public void show() {
        view.setVisible(true);
        this.refrescarBusqueda();
    }

    public void showProfesor() {
        Frontend_desktop.PROFESOR_CONTROLLER.show();
    }

    public void refrescarBusqueda() {
        List<Profesor> rows;
        rows = domainModel.listarProfesores();

        model.setProfesores(rows);
        model.commit();
        //if (rows.isEmpty()) throw new Exception("Ningún dato coincide");
    }

    public void hide() {
        this.view.setVisible(false);
    }

    public int eliminarProfesor(int row) {
        Profesor toDelete = this.model.getProfesores().getRows().get(row);
        if (this.domainModel.eliminarProfesor(toDelete.getId()) == 1) {
            this.refrescarBusqueda();
            return 1;
        }
        return 0;

    }

    public void reset(int row) {
        Profesor toShow = this.model.getProfesores().getRows().get(row);
        Frontend_desktop.PROFESOR_CONTROLLER.reset(Frontend_desktop.MODO_EDITAR, toShow);
        Frontend_desktop.PROFESOR_CONTROLLER.show();
    }
    public void filtrar(String cedula){
        List<Profesor> profes = this.model.getProfesores().getRows();
        List<Profesor> filtro = new ArrayList();
        profes.stream().filter((profe) -> (profe.getCedula().contains(cedula))).forEachOrdered((profe) -> {
            filtro.add(profe);
        });
       this.model.setProfesores(filtro);
       this.model.commit();
    }
}
