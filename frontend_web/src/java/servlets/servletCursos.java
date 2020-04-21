/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import BusinessLogic.Curso;
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
public class servletCursos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
            System.out.println("getCursos");
            Model dm1 = Model.instance();
            Control dm = new Control(dm1);
            
            String json = new Gson().toJson(dm.listarCursos());
            response.setContentType("aplication/json");
            response.setCharacterEncoding("UTF-8");
            System.out.println(json);
            response.getWriter().println(json);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("intenta insertar");
        int codigoCurso = Integer.parseInt(request.getParameter("codigoCurso"));
        String nombreCurso = request.getParameter("nombreCurso");
        int horasSemanales = Integer.parseInt(request.getParameter("horasSemanales"));
        int creditosCurso = Integer.parseInt(request.getParameter("creditosCurso"));
        
         Curso c1 = new Curso(0,codigoCurso,nombreCurso,horasSemanales,creditosCurso);
//            System.out.println("curso a insertar: "+c1.toString());
            Model dm1 = Model.instance();
            Control dm = new Control(dm1);
//            System.out.println("intenta insertar");
            dm.insertarCurso(c1);
            String json = new Gson().toJson("insertado");
            response.getWriter().println(json);
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigoCurso = Integer.parseInt(request.getParameter("codigoCurso"));
        String nombreCurso = request.getParameter("nombreCurso");
        int horasSemanales = Integer.parseInt(request.getParameter("horasSemanales"));
        int creditosCurso = Integer.parseInt(request.getParameter("creditosCurso"));
         int x = Integer.parseInt(request.getParameter("x"));
        Curso c1 = new Curso(x,codigoCurso,nombreCurso,creditosCurso,horasSemanales);
        System.out.println("curso a insertar: "+c1.toString());
        Model dm1 = Model.instance();
        Control dm = new Control(dm1);
        System.out.println("intenta insertar");
        dm.modificarCurso(c1);
        String json = new Gson().toJson("actualizado con exito");
        response.getWriter().println(json);
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int x = Integer.parseInt(request.getParameter("x"));
        Model dm1 = Model.instance();
        Control dm = new Control(dm1);
       
        int result =  dm.eliminarCurso(x);
        String json = new Gson().toJson(result);
        response.getWriter().println(json);
    }

}
