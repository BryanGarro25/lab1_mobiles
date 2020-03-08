/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import BusinessLogic.Usuario;
import Controllers.Control;
import Model.Model;
import java.net.URISyntaxException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Bryan
 */
@Path("login")
public class loginResource {
    
    private Control dm;
    @Context
    private UriInfo context;

    @POST
    @Path("tryLogin")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response  tryLogin(
    @FormParam("username") String username,
    @FormParam("password") String password
    ){
        try {
            Usuario p1 = new Usuario(username,password);
            System.out.println("usuario: "+p1.toString());
            Model dm1 = Model.instance();
            dm = new Control(dm1);
            System.out.println("intenta loggear");
            if (dm.login(p1) == true){
                System.out.println(" login exitoso");

                java.net.URI location = new java.net.URI("../pages/profesorCRUD.jsp");
                return Response.temporaryRedirect(location).build();

            }else{System.out.println(" login fallidos");return null;}
                
        } catch (Exception e) {
            System.out.println(" login fallidoss");
            e.printStackTrace();
        }
        return null;
    }
   
 
}
