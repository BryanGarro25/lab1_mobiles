/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BusinessLogic.Curso;
import BusinessLogic.Profesor;
import BusinessLogic.Usuario;
import Model.InterfaceModel;
import java.util.List;

/**
 *
 * @author Josue
 */
public class Control {

    protected InterfaceModel model;

    public Control() {

    }

    public Control(InterfaceModel model) {
        this.model = model;
    }

    public int insertarCurso(Curso curso) {
        try {
            this.model.insertarCurso(curso);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int modificarCurso(Curso curso) {
        try {
            this.model.modificarCurso(curso);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int eliminarCurso(int id) {
        try {
            this.model.eliminarCurso(id);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public List<Curso> listarCursos() {
        try {
            return this.model.listarCursos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Curso buscarCurso(int id) {
        try {
            return this.model.buscarCurso(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int insertarProfesor(Profesor profesor) {
        try {
            this.model.insertarProfesor(profesor);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public List<Profesor> listarProfesores() {
        try {
            return this.model.listarProfesores();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int eliminarProfesor(int id) {
        try {
            this.model.eliminarProfesor(id);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int modificarProfesor(Profesor profesor) {
        try {
            this.model.modificarProfesor(profesor);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public boolean login(Usuario usuario) {
        try {
            return this.model.login(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
