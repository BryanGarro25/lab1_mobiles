/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import BusinessLogic.Profesor;
import Controllers.Control;
import Model.Model;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bryan
 */
public class servletProfesores extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
            System.out.println("getCursos");
            Model dm1 = Model.instance();
            Control dm = new Control(dm1);
            
            String json = new Gson().toJson(dm.listarProfesores());
            response.setContentType("aplication/json");
            response.setCharacterEncoding("UTF-8");
            System.out.println(json);
            response.getWriter().println(json);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("servlet insertar");
        
        String cedula = request.getParameter("cedula");
        String nombreProfesor = request.getParameter("nombreProfesor");
        int telefonoProfesor = Integer.parseInt(request.getParameter("telefonoProfesor"));
        String emailProfesor = request.getParameter("emailProfesor");
        
        System.out.println("servlet insertar");
        Profesor c1 = new Profesor(0,cedula,nombreProfesor,telefonoProfesor,emailProfesor);
//            System.out.println("curso a insertar: "+c1.toString());
            Model dm1 = Model.instance();
            Control dm = new Control(dm1);
//            System.out.println("intenta insertar");
            dm.insertarProfesor(c1);
            String json = new Gson().toJson("insertado");
            response.getWriter().println(json);
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        String cedula = request.getParameter("cedula");
        String nombreProfesor = request.getParameter("nombreProfesor");
        int telefonoProfesor = Integer.parseInt(request.getParameter("telefonoProfesor"));
        String emailProfesor = request.getParameter("emailProfesor");

        int x = Integer.parseInt(request.getParameter("x"));
         
        Profesor c1 = new Profesor(x,cedula,nombreProfesor,telefonoProfesor,emailProfesor);
//        System.out.println("curso a insertar: "+c1.toString());
        Model dm1 = Model.instance();
        Control dm = new Control(dm1);
//        System.out.println("intenta insertar");
        dm.modificarProfesor(c1);
        String json = new Gson().toJson("actualizado con exito");
        response.getWriter().println(json);
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int x = Integer.parseInt(request.getParameter("x"));
        Model dm1 = Model.instance();
        Control dm = new Control(dm1);
       
        int result =  dm.eliminarProfesor(x);
        String json = new Gson().toJson(result);
        response.getWriter().println(json);
    }




}
