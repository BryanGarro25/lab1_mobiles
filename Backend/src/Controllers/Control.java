/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BusinessLogic.Curso;
import Model.InterfaceModel;
import java.util.List;

/**
 *
 * @author Josue
 */
public class Control {

    protected InterfaceModel model;
    public Control(){
        
    }
    public Control(InterfaceModel model) {
        this.model = model;
    }

    public int insertarCurso(String codigo, String nombre, int creditos, int horas_semanales) {
        try {
            Curso curso = new Curso(0, codigo, nombre, creditos, horas_semanales);
            this.model.insertarCurso(curso);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int modificarCurso(int id, String codigo, String nombre, int creditos, int horas_semanales) {
        try {
            Curso curso = new Curso(id, codigo, nombre, creditos, horas_semanales);
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
}
