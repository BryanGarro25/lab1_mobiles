/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend_desktop;

import Control.CursoController;
import Control.CursosController;
import Control.LoginController;
import Control.MenuController;
import Control.ProfesorController;
import Control.ProfesoresController;
import Model.Model;
import Controllers.Control;
import Model.CursoModel;
import Model.CursosModel;
import Model.LoginModel;
import Model.MenuModel;
import Model.ProfesorModel;
import Model.ProfesoresModel;
import Presentation.CursoView;
import Presentation.CursosView;
import Presentation.LoginView;
import Presentation.MenuView;
import Presentation.ProfesorView;
import Presentation.ProfesoresView;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Bryan
 */
public class Frontend_desktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model domainModel = Model.instance();
        Control control = new Control(domainModel);
        //--------------------LOGIN------------------
        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView();
        LoginController logincontroller = new LoginController(loginView, loginModel, control);
        LOGIN_CONTROLLER = logincontroller;
        loginView.setVisible(true);
        //--------------MENU PRINCIPAL DE LA APLICACION
        MenuModel applicationModel = new MenuModel();
        MenuView applicationView = new MenuView();
        MenuController applicationController = new MenuController(applicationModel, applicationView, control);
        APPLICATION_CONTROLLER = applicationController;
        APPLICATION_VIEW = applicationView;
        //-------------PROFESORES-----------------------------------
        ProfesoresModel profesoresModel = new ProfesoresModel();
        ProfesoresView profesoresView = new ProfesoresView();
        applicationView.addInternalFrame(profesoresView);
        ProfesoresController profesoresController = new ProfesoresController(profesoresView, profesoresModel, control);
        PROFESORES_CONTROLLER = profesoresController;
        //--------------------------PROFESOR---------------------------
        ProfesorModel profesorModel = new ProfesorModel();
        ProfesorView profesorView = new ProfesorView(APPLICATION_VIEW, true);
        ProfesorController profesorController = new ProfesorController(control, profesorView, profesorModel);
        PROFESOR_CONTROLLER = profesorController;
        //--------------------------CURSOS---------------------------
        CursosModel cursosModel = new CursosModel();
        CursosView cursosView = new CursosView();
        applicationView.addInternalFrame(cursosView);
        CursosController cursosController = new CursosController(cursosView, cursosModel, control);
        CURSOS_CONTROLLER = cursosController;
        //--------------------------CURSO---------------------------
        CursoModel cursoModel = new CursoModel();
        CursoView cursoView = new CursoView(APPLICATION_VIEW, true);
        CursoController cursoController = new CursoController(cursoView, cursoModel, control);
        CURSO_CONTROLLER = cursoController;
    }
    public static MenuController APPLICATION_CONTROLLER;
    public static LoginController LOGIN_CONTROLLER;
    public static ProfesoresController PROFESORES_CONTROLLER;
    public static ProfesorController PROFESOR_CONTROLLER;
    public static CursosController CURSOS_CONTROLLER;
    public static CursoController CURSO_CONTROLLER;

    public static MenuView APPLICATION_VIEW;

    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);

    public static final Color COLOR_ERROR = Color.red;
    public static final Color COLOR_OK = Color.black;

    public static final int MODO_AGREGAR = 0;
    public static final int MODO_EDITAR = 1;
}
