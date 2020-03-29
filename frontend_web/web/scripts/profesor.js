/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function creartabla(){
//        var url = "../api/profesores/all";
      var url = "../servletProfesores";
        fetch(url).then(r => {
            return r.json();
        }).then(d => {
            var obj = JSON.stringify(d);
            var obj2 = JSON.parse(obj);
            console.log(obj2);
            let tbody = document.getElementById("tbody_tabla_de_profesores");
            for(let x = 0; x< obj2.length;x++){
                let tr = document.createElement("tr");
                
                let cedula = document.createElement("td");
                cedula.innerHTML = obj2[x].cedula;
                tr.appendChild(cedula);
                
                let nombre = document.createElement("td");
                nombre.innerHTML = obj2[x].nombre;
                tr.appendChild(nombre);
                
                let telefono = document.createElement("td");
                telefono.innerHTML = obj2[x].telefono;
                tr.appendChild(telefono);
                
                let email = document.createElement("td");
                email.innerHTML = obj2[x].email;
                tr.appendChild(email);
                
                
                let botontd2 = document.createElement("td");
                let boton2 = document.createElement("button");
                boton2.onclick = function () {editar(obj2[x].id);};
                boton2.innerHTML = "editar";
                botontd2.appendChild(boton2);
                tr.appendChild(botontd2);
                
                
                let botontd = document.createElement("td");
                let boton = document.createElement("button");
                boton.onclick = function () {eliminar(obj2[x].id);};
                boton.innerHTML = "eliminar";
                botontd.appendChild(boton);
                tr.appendChild(botontd);
                
                tr.id = obj2[x].id;
                
                tbody.appendChild(tr);
            }
            
            
            $(document).ready(function() {
                $('#tabla_de_profesores').DataTable({
                  "language": {
                        "lengthMenu": "Mostrar _MENU_ Profesores",
                        "zeroRecords": "Sin resultados encontrados",
                        "info": "Mostrando _START_ a _END_ de _TOTAL_ Profesores",
                        "infoEmpty": "Mostrando 0 to 0 of 0 Profesores",
                        "infoFiltered": "(Filtrado de _MAX_ total Profesores)",
                        "processing": "Procesando...",
                        "loadingRecords": "Cargando...",
                        "search": "Buscar:",
                        "paginate": {
                            "first": "Primero",
                            "last": "Ultimo",
                            "next": "Siguiente",
                            "previous": "Anterior"
                        }
                    }
                });
            });
        
        
        });//second then
    
}

function addrow() {
    var table = $('#tabla_de_profesores').DataTable();
    table.destroy();
    var tableElement = document.getElementById('tabla_de_profesores');
    var oldTbody = document.getElementById("tbody_tabla_de_profesores");
    tableElement.removeChild(oldTbody);
    var newTbody = document.createElement('tbody');
    newTbody.id = 'tbody_tabla_de_profesores';
    tableElement.appendChild(newTbody);
    creartabla();
//    $('#tabla_de_profesores').dataTable().fnAddData( [
//        $('#inputcedulaProfesor').val(),
//        $('#nombreProfesor').val(),
//        $('#telefonoProfesor').val(),
//        $('#emailProfesor').val() ] );

}
function clearparams(){
    document.getElementById('cedulaProfesor').value='';
    document.getElementById('nombreProfesor').value='';
    document.getElementById('telefonoProfesor').value='';
    document.getElementById('emailProfesor').value='';
    
    
}

function eliminar(x){
    console.log('elimina: '+x);
//     var url = "../api/profesores/delete/"+x ;
  var aux = "../servletProfesores?" +
            "x={0}";
    var url = aux.format(
            x);
     fetch(url,{method: 'DELETE'}).then(r => {
        return r.json();
        }).then(d => {
            var obj = JSON.stringify(d);
            var obj2 = JSON.parse(obj);
            console.log(obj2);
            addrow();
        });//second then
    
}

function guardar(){
    var cedula = document.getElementById('cedulaProfesor').value;
    var nombreProfesor = document.getElementById('nombreProfesor').value;
    var telefonoProfesor = document.getElementById('telefonoProfesor').value;
    var emailProfesor = document.getElementById('emailProfesor').value;
        var aux = "../servletProfesores?" +
            "cedula={0}&nombreProfesor={1}&telefonoProfesor={2}&emailProfesor={3}";
    var url = aux.format(
            cedula, nombreProfesor, telefonoProfesor,emailProfesor);
//    var url = "../api/profesores/insert/"+cedula+"/"+nombreProfesor+"/"+telefonoProfesor+"/"+emailProfesor;
         fetch(url,{method: 'POST'}).then(r => {
        return r.json();
        }).then(d => {
            var obj = JSON.stringify(d);
            var obj2 = JSON.parse(obj);
            console.log(obj2);
            addrow();
            clearparams();
        }).catch(err => {
          console.log("Error Reading data " + err);
          addrow();
          clearparams();
        });
    
}

function update(x){
    var cedula = document.getElementById('cedulaProfesor').value;
    var nombreProfesor = document.getElementById('nombreProfesor').value;
    var telefonoProfesor = document.getElementById('telefonoProfesor').value;
    var emailProfesor = document.getElementById('emailProfesor').value;
           var aux = "../servletProfesores?" +
            "cedula={0}&nombreProfesor={1}&telefonoProfesor={2}&emailProfesor={3}";
    var url = aux.format(
            cedula, nombreProfesor, telefonoProfesor,emailProfesor);
//    var url = "../api/profesores/update/"+cedula+"/"+nombreProfesor+"/"+telefonoProfesor+"/"+emailProfesor+"/"+x;
         fetch(url,{method: 'PUT'}).then(r => {
        return r.json();
        }).then(d => {
            var obj = JSON.stringify(d);
            var obj2 = JSON.parse(obj);
            console.log(obj2);
            addrow();
            clearparams();
        }).catch(err => {
          console.log("Error Reading data " + err);
          addrow();
          clearparams();
        });
}


function editar(x){
    var profesor = document.getElementById(x);
    var list = profesor.childNodes;
    
    for(let i = 0; i< list.length-2;i++)
        console.log(profesor.childNodes[i].innerHTML);
    
    document.getElementById('cedulaProfesor').value=profesor.childNodes[0].innerHTML;
    document.getElementById('nombreProfesor').value=profesor.childNodes[1].innerHTML;
    document.getElementById('telefonoProfesor').value=profesor.childNodes[2].innerHTML;
    document.getElementById('emailProfesor').value=profesor.childNodes[3].innerHTML;
    
    
//    var form = document.getElementById('profesorForm');
//    form.action = "../api/profesores/update";
    
    var botonSalirModo = document.getElementById('salirModoEdicion');
    botonSalirModo.style.display = '';
    
    var botonSumit = document.getElementById('registrarActivoBoton');
    botonSumit.innerHTML = 'Editar Profesor';
   document.getElementById("cedulaProfesor").disabled = true;
   botonSumit.onclick = function(){update(x);};
    // programar el otro boton para que revierta esos cambios
}

function salidModoEdicion(){
    clearparams();
    
//    var form = document.getElementById('profesorForm');
//    form.action = "../api/profesores/insert";
    
    var botonSalirModo = document.getElementById('salirModoEdicion');
    botonSalirModo.style.display = 'none';
    
    var botonSumit = document.getElementById('registrarActivoBoton');
    botonSumit.innerHTML = 'Registrar Profesor';
   document.getElementById("cedulaProfesor").disabled = false;
   botonSumit.onclick = function(){guardar();};
   
}

String.prototype.format = function () {
    var a = this;
    for (var k in arguments) {
        a = a.replace("{" + k + "}", arguments[k]);
    }
    return a;
};