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
        <link href="../css/cursoCRUD.css" rel="stylesheet" type="text/css">
        <script src="../scripts/curso.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body onload="creartabla();">
        <%@include file="navBar.jsp"%>
        <div>
            <!--form id="profesorForm" method="POST" action="../api/profesores/insert" -->
                
                <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputEmail4">Codigo del Curso</label>
                      <input type="text" class="form-control" id="codigoCurso" placeholder="codigo" name = "codigoCurso">
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputPassword4">Nombre</label>
                      <input type="text" class="form-control" id="nombreCurso" placeholder="Nombre" name="nombreCurso">
                    </div>
                </div>
                
                
                
                 <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputEmail4">Horas Semanales</label>
                      <input type="text" class="form-control" id="horasSemanales" placeholder="Ingrese total de horas semanales" name = "horasSemanales">
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputPassword4">Total de Creditos</label>
                      <input type="email" class="form-control" id="creditosCurso" placeholder="Ingrese total de creditos" name="creditosCurso">
                    </div>
                </div>
               
 
                <button onclick = 'guardar();' type="submit" class="btn btn-primary" id="registrarCursoBoton">
                    Registrar Curso
                </button>
                <button onclick = 'salidModoEdicion();' class="btn btn-primary" id="salirModoEdicion"  style="display: none">
                    salir de modo edicion 
                </button>
            <!--/form-->
        </div>
        <div>
            <table id = "tabla_de_cursos">
                <thead>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Horas Semanales</th>
                    <th>Creditos</th>
                    <th>Accion</th>
                    <th>Accion</th>
                </thead>
                    <tbody id = "tbody_tabla_de_cursos">
                    </tbody>    
            </table>
        </div>
    </body>
    <!--script>
        $('#profesorForm').submit(function() {
            this.submit();
            
            addrow();
            clearparams();
        });
    </script-->
</html>