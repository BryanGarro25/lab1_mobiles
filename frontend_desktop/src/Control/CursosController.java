/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BusinessLogic.Curso;
import Controllers.Control;
import Model.CursosModel;
import Presentation.CursosView;
import java.util.List;

/**
 *
 * @author Josue
 */
public class CursosController {
    Control domainModel;
    CursosView view;
    CursosModel model;

    public CursosController(CursosView view,  CursosModel model, Control domainModel) {
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
 
    public void refrescarBusqueda(){
        List<Curso> rows = domainModel.listarCursos();
        model.setCursos(rows);
        model.commit();
        //if (rows.isEmpty()) throw new Exception("Ningún dato coincide");
    }   
}
