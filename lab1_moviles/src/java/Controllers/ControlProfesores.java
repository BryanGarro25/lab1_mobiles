/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BusinessLogic.Profesor;
import DataAccess.ServicioProfesor;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Josue
 */
@Path("/profesores")
public class ControlProfesores {

    private final ServicioProfesor servicioProfesor = ServicioProfesor.obtenerInstancia();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Profesor> obtenerProfesores() {
        //return servicioProfesor.getProfesor();
        return null;
    }
    @GET
    @Path("/{cedula}")
    @Produces({MediaType.APPLICATION_JSON})
    public int obtenerProfesor(@PathParam("cedula") String cedula){
        int n = 8;
        return n;
        //return null;
    }
}
