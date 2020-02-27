/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessLogic.Curso;

import Control.LoginController;
import Control.MenuController;
import Control.ProfesoresController;
import Model.Model;
import Controllers.Control;
import Model.LoginModel;
import Model.MenuModel;
import Model.ProfesoresModel;
import Presentation.LoginView;
import Presentation.MenuView;
import Presentation.ProfesoresView;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Josue
 */
public class ServicioCurso extends Servicio{
    public static ServicioCurso instancia = null;

    private ServicioCurso() {

<<<<<<< HEAD:lab1_moviles/src/java/DataAccess/ServicioCurso.java
    }

    public static ServicioCurso obtenerInstancia() {
        if (instancia == null) {
            instancia = new ServicioCurso();
        }
        return instancia;
    }
    public Curso getCurso(){
        return null;
    }
=======
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model domainModel = Model.instance();
        Control control = new Control(domainModel);
        //-------LOGIN---------------------------
        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView();
        LoginController logincontroller = new LoginController(loginView, loginModel, control);
        LOGIN_CONTROLLER = logincontroller;
        loginView.setVisible(true);
        //-------MENU PRINCIPAL---------------------------
        MenuModel applicationModel = new MenuModel();
        MenuView applicationView = new MenuView();
        MenuController applicationController = new MenuController(applicationModel, applicationView, control);
        APPLICATION_CONTROLLER = applicationController;
        APPLICATION_VIEW = applicationView;
        
         //-------PROFESORES---------------------------
         ProfesoresModel profesoresModel  = new ProfesoresModel();
         ProfesoresView profesoresView = new ProfesoresView();
         ProfesoresController profesoresController = new ProfesoresController(profesoresView, profesoresModel, control);
         applicationView.addInternalFrame(profesoresView);
         PROFESORES_CONTROLLER = profesoresController;
    }
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);

    public static MenuController APPLICATION_CONTROLLER;
    public static MenuView APPLICATION_VIEW;
    public static LoginController LOGIN_CONTROLLER;
    public static ProfesoresController PROFESORES_CONTROLLER;

    public static final Color COLOR_ERROR = Color.red;
    public static final Color COLOR_OK = Color.black;
>>>>>>> master:FrontendDesktop/src/frontenddesktop/FrontendDesktop.java
}
