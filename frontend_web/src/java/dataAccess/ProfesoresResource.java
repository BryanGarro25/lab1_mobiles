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
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
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
            return dm.listarProfesores();
        } catch (Exception e) {
            return null;
        }

    }
    
    @POST
    @Path("insert")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void insert(
    @FormParam("cedulaProfesor") String cedulaProfesor,
    @FormParam("nombreProfesor") String nombreProfesor,
    @FormParam("telefonoProfesor") int telefonoProfesor,
    @FormParam("emailProfesor") String emailProfesor
    
    ){
        try {
            Profesor p1 = new Profesor(0,cedulaProfesor,nombreProfesor,telefonoProfesor,emailProfesor);
            System.out.println("profesror a insertar: "+p1.toString());
            Model dm1 = Model.instance();
            dm = new Control(dm1);
            System.out.println("intenta insertar");
            dm.insertarProfesor(p1);
        } catch (Exception e) {
            
        }
    }
    
    @POST
    @Path("update")
//    @Consumes(MediaType.MULTIPART_FORM_DATA) se usa cuando se envian archivos
    public void update(
    @FormParam("cedulaProfesor") String cedulaProfesor,
    @FormParam("nombreProfesor") String nombreProfesor,
    @FormParam("telefonoProfesor") int telefonoProfesor,
    @FormParam("emailProfesor") String emailProfesor
    
    ){
        try {
            Profesor p1 = new Profesor(0,cedulaProfesor,nombreProfesor,telefonoProfesor,emailProfesor);
            System.out.println("profesror a actualizar: "+p1.toString());
            Model dm1 = Model.instance();
            dm = new Control(dm1);
            System.out.println("intenta actualizar");
            dm.modificarProfesor(p1);
        } catch (Exception e) {
            
        }
    }
    
    
    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String eliminar(@PathParam("id") int id){
        Model dm1 = Model.instance();
        dm = new Control(dm1);
       
        int result =  dm.eliminarProfesor(id);
        return String.valueOf(result);
    }
}
