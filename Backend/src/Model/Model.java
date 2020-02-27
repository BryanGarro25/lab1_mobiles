/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BusinessLogic.Curso;
import BusinessLogic.Profesor;
import BusinessLogic.Usuario;
import Data.ServicioCurso;
import Data.ServicioProfesor;
import Data.ServicioUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue
 */
public class Model implements InterfaceModel {

    private final ServicioCurso servicioCurso;
    private final ServicioProfesor servicioProfesor;

    private static Model uniqueInstance;

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model() {
            };
        }
        return uniqueInstance;
    }

    private Model() {
        servicioCurso = new ServicioCurso();
        servicioProfesor = new ServicioProfesor();

    }

    @Override
    public void insertarCurso(Curso cur) throws Exception {
        ServicioCurso.instance().insertarCurso(cur);
    }

    @Override
    public ArrayList<Curso> listarCursos() throws Exception {
        return ServicioCurso.instance().listarCursos();
    }

    @Override
    public void modificarCurso(Curso cur) throws Exception {
        ServicioCurso.instance().modificarCurso(cur);
    }

    @Override
    public void eliminarCurso(int cod) throws Exception {
        ServicioCurso.instance().eliminarCurso(cod);
    }

    @Override
    public Curso buscarCurso(int cod) throws Exception {
        return ServicioCurso.instance().buscarCurso(cod);

    }
    @Override
    public void insertarProfesor(Profesor profesor) throws Exception {
        ServicioProfesor.instance().insertarProfesor(profesor);
    }
    @Override
    public Profesor buscarProfesor(int idProf) throws Exception {
        return ServicioProfesor.instance().buscarProfesor(idProf);
    }

    @Override
    public List<Profesor> listarProfesores() throws Exception {
        return ServicioProfesor.instance().listarProfesores();
    }
    @Override
    public void eliminarProfesor(int cod) throws Exception {
        ServicioProfesor.instance().eliminarProfesor(cod);
    }
    @Override
    public void modificarProfesor(Profesor profesor) throws Exception {
        ServicioProfesor.instance().modificarProfesor(profesor);
    }
    @Override
    public boolean login(Usuario usuario){
       return ServicioUsuario.instance().login(usuario);
    }
}
