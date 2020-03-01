/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Controllers.Control;
import Model.MenuModel;
import Presentation.MenuView;
import frontend_desktop.Frontend_desktop;

/**
 *
 * @author Josue
 */
public class MenuController {

    MenuModel model;
    MenuView view;
    Control domainModel;

    public MenuController(MenuModel model, MenuView view, Control control) {
        this.model = model;
        this.view = view;
        this.domainModel = control;
        view.setController(this);
        view.setModel(model);

    }

    public void show() {
        view.setVisible(true);
    }

    public void enter() {
        this.show();
    }

    public void exit() {
        this.hide();
        Frontend_desktop.LOGIN_CONTROLLER.logout();
    }

    public void hide() {
        view.setVisible(false);
    }

    public void showProfesores() {
        Frontend_desktop.PROFESORES_CONTROLLER.show();
    }
     public void showCursos() {
        Frontend_desktop.CURSOS_CONTROLLER.show();
    }
}