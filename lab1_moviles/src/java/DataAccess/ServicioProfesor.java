/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessLogic.Profesor;

/**
 *
 * @author Josue
 */
public class ServicioProfesor extends Servicio {

    public static ServicioProfesor instancia = null;

    private ServicioProfesor() {

    }

    public static ServicioProfesor obtenerInstancia() {
        if (instancia == null) {
            instancia = new ServicioProfesor();
        }
        return instancia;
    }
    public Profesor getProfesor(){
        return null;
    }
}
