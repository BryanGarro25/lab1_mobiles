/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import BusinessLogic.Curso;
import BusinessLogic.Profesor;
import Controllers.Control;
import Model.Model;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Bryan
 */
@Path("/cursos")
public class CursosResource {
    
    private Control dm;
    @Context
    private UriInfo context;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public List<Curso> getAll() {
        try {
            Model dm1 = Model.instance();
            dm = new Control(dm1);
            return dm.listarCursos();
        } catch (Exception e) {
            return null;
        }

    }
    
        @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String eliminar(@PathParam("id") int id){
        Model dm1 = Model.instance();
        dm = new Control(dm1);
       
        int result =  dm.eliminarCurso(id);
        return String.valueOf(result);
    }
    
    
    @GET
    @Path("insert/{codigoCurso}/{nombreCurso}/{horasSemanales}/{emailProfesor}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String insert(
    @PathParam("codigoCurso") int codigoCurso,
    @PathParam("nombreCurso") String nombreCurso,
    @PathParam("horasSemanales") int horasSemanales,
    @PathParam("creditosCurso") int creditosCurso
    
    ){
        try {
            Curso c1 = new Curso(0,codigoCurso,nombreCurso,horasSemanales,creditosCurso);
            System.out.println("curso a insertar: "+c1.toString());
            Model dm1 = Model.instance();
            dm = new Control(dm1);
            System.out.println("intenta insertar");
            dm.insertarCurso(c1);
            return "bueno";
        } catch (Exception e) {
            return "malo";
        }
    }
    
    @GET
    @Path("update/{codigoCurso}/{nombreCurso}/{horasSemanales}/{emailProfesor}/{x}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(
    @PathParam("codigoCurso") int codigoCurso,
    @PathParam("nombreCurso") String nombreCurso,
    @PathParam("horasSemanales") int horasSemanales,
    @PathParam("creditosCurso") int creditosCurso,
    @PathParam("x") int x
    
    ){
        try {
            Curso c1 = new Curso(x,codigoCurso,nombreCurso,horasSemanales,creditosCurso);
            System.out.println("curso a insertar: "+c1.toString());
            Model dm1 = Model.instance();
            dm = new Control(dm1);
            System.out.println("intenta insertar");
            dm.modificarCurso(c1);
            return "bueno";
        } catch (Exception e) {
            return "malo";
        }
    }
    

}
