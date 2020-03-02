/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import BusinessLogic.Profesor;
import Controllers.Control;
import Model.Model;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Bryan
 */
@Path("/profesores")
public class ProfesoresResource {

    private Control dm;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProfesoresResource
     */
    public ProfesoresResource() {
        Model dm1 = Model.instance();
        dm = new Control(dm1);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public List<Profesor> getAll() {
        try {
            Model dm1 = Model.instance();
            dm = new Control(dm1);
//            System.out.println(dm.listarProfesores());
//            return dm.listarProfesores();
        if(dm == null)
            System.out.println("aqui va");
        System.out.println("lista: "+ dm.listarProfesores());
            return dm.listarProfesores();
        } catch (Exception e) {
            return null;
        }

    }
}
