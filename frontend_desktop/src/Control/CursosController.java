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
import frontend_desktop.Frontend_desktop;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue
 */
public class CursosController {

    Control domainModel;
    CursosView view;
    CursosModel model;

    public CursosController(CursosView view, CursosModel model, Control domainModel) {
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

    public void refrescarBusqueda() {
        List<Curso> rows = domainModel.listarCursos();

        model.setCursos(rows);
        model.commit();
        //if (rows.isEmpty()) throw new Exception("Ningún dato coincide");
    }

    public void showCurso() {
        Frontend_desktop.CURSO_CONTROLLER.show();
    }

    public void hide() {
        view.setVisible(false);
    }

    public int eliminarCurso(int row) {
        Curso toDelete = this.model.getCursos().getRows().get(row);
        if (this.domainModel.eliminarCurso(toDelete.getId()) == 1) {
            this.refrescarBusqueda();
            return 1;
        }
        return 0;

    }

    public void reset(int row) {
        Curso toShow = this.model.getCursos().getRows().get(row);
        Frontend_desktop.CURSO_CONTROLLER.reset(Frontend_desktop.MODO_EDITAR, toShow);
        Frontend_desktop.CURSO_CONTROLLER.show();
    }
     public void filtrar(String codigo){
        List<Curso> cursos = this.model.getCursos().getRows();
        List<Curso> filtro = new ArrayList();
        cursos.forEach((curso) -> {
            String result = Integer.toString(curso.getCodigo());
            if(result.contains(codigo)){
                 filtro.add(curso);
            }
           
        });
       this.model.setCursos(filtro);
       this.model.commit();
    }
}
