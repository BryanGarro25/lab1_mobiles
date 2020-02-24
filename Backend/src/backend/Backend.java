/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import Model.InterfaceModel;
import BusinessLogic.*;
import Controllers.Control;
import Model.Model;
        

/**
 *
 * @author Josue
 */
public class Backend {
     public static void main(String[] args) {
        //PRUEBAS DE BACKEND 
        //1-PRUEBAS CURSO 
        Curso curso = new Curso(0, "111", "Mate",3,5);
        InterfaceModel model;
        Control control = new Control(model);
        int i = control.insertarCurso(curso.getCodigo(), curso.getNombre(), curso.getCreditos(), curso.getHorasSemanales());
        System.out.println(i);
    }
}
