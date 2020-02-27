/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessLogic.Curso;
import BusinessLogic.Profesor;
import BusinessLogic.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue
 */
public interface InterfaceModel {
    //--------------------Curso-------------------------- 

    public void insertarCurso(Curso cur) throws Exception;

    public ArrayList<Curso> listarCursos() throws Exception;

    public void modificarCurso(Curso cur) throws Exception;

    public void eliminarCurso(int cod) throws Exception;

    public Curso buscarCurso(int cod) throws Exception;

    //-------------------Profesor-------------------------- 
    public void insertarProfesor(Profesor profesor) throws Exception;

    public Profesor buscarProfesor(int id) throws Exception;

    public List<Profesor> listarProfesores() throws Exception;

    public void eliminarProfesor(int id) throws Exception;

    public void modificarProfesor(Profesor profesor) throws Exception;
    
    public boolean login(Usuario usuario) throws Exception;
}
