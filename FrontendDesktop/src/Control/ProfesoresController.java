/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Controllers.Control;
import Model.ProfesoresModel;
import Presentation.ProfesoresView;

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
        int i = 0;
    }

}
