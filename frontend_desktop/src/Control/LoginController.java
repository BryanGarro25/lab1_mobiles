/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import BusinessLogic.Usuario;
import Controllers.Control;
import Model.LoginModel;
import Presentation.LoginView;
import frontend_desktop.Frontend_desktop;

/**
 *
 * @author Josue
 */
public class LoginController {

    Control control;
    LoginView view;
    LoginModel model;

    public LoginController(LoginView view, LoginModel model, Control control) {
        this.view = view;
        this.model = model;
        this.control = control;
        this.view.setController(this);
        view.setModel(model);
    }

    public boolean login(Usuario typed) throws Exception {
        // model.setCurrent(typed);
        if (control.login(typed)) {
            view.setVisible(false);
            Frontend_desktop.APPLICATION_CONTROLLER.enter();
            return true;
        }
        return false;
        //session.setAttibute(Application.USER_ATTRIBUTE, real);
        // Application.APPLICATION_CONTROLLER.enter();

    }

    public void logout() {
        view.setVisible(true);
    }

    public void exit() {
        System.exit(0);
    }
}
