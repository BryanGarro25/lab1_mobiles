/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessLogic.Curso;

/**
 *
 * @author Josue
 */
public class ServicioCurso extends Servicio{
    public static ServicioCurso instancia = null;

    private ServicioCurso() {

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
}
