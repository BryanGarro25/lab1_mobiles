<%-- 
    Document   : profesorCRUD
    Created on : Mar 1, 2020, 3:05:20 PM
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src = "https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src = "https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
        <script src = "https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
        <link href="../css/navBar.css" rel="stylesheet" type="text/css">
        <link href="../css/profesorCRUD.css" rel="stylesheet" type="text/css">
        <script src="../scripts/profesor.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body onload="creartabla();">
        <%@include file="navBar.jsp"%>
        <div>
            <form id="profesorForm" method="POST" action="../api/profesores/insert" >
                
                <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputEmail4">Cedula</label>
                      <input type="text" class="form-control" id="cedulaProfesor" placeholder="1-1111-1111" name = "cedulaProfesor">
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputPassword4">Nombre</label>
                      <input type="text" class="form-control" id="nombreProfesor" placeholder="Nombre" name="nombreProfesor">
                    </div>
                </div>
                
                
                
                 <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputEmail4">telefono</label>
                      <input type="text" class="form-control" id="telefonoProfesor" placeholder="0000-0000" name = "telefonoProfesor">
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputPassword4">Email</label>
                      <input type="email" class="form-control" id="emailProfesor" placeholder="Ingrese Email" name="emailProfesor">
                    </div>
                </div>
               
 
                <button type="submit" class="btn btn-primary" id="registrarActivoBoton">
                    Registrar Profesor
                </button>
                <button onclick = 'salidModoEdicion();' class="btn btn-primary" id="salirModoEdicion"  style="display: none">
                    salir de modo edicion 
                </button>
            </form>
        </div>
        <div>
            <table id = "tabla_de_profesores">
                <thead>
                    <th>cedula</th>
                    <th>nombre</th>
                    <th>telefono</th>
                    <th>email</th>
                    <th>Accion</th>
                    <th>Accion</th>
                </thead>
                    <tbody id = "tbody_tabla_de_profesores">
                    </tbody>    
            </table>
        </div>
    </body>
    <script>
        $('#profesorForm').submit(function() {
            this.submit();
            
            addrow();
            clearparams();
        });
    </script>
</html>
