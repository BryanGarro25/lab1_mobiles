/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function creartabla(){
//        var url = "../api/cursos/all";
        var url = "../servletCursos";
        fetch(url).then(r => {
            return r.json();
        }).then(d => {
            var obj = JSON.stringify(d);
            var obj2 = JSON.parse(obj);
            console.log(obj2);
            let tbody = document.getElementById("tbody_tabla_de_cursos");
            for(let x = 0; x< obj2.length;x++){
                let tr = document.createElement("tr");
                
                let cedula = document.createElement("td");
                cedula.innerHTML = obj2[x].codigo;
                tr.appendChild(cedula);
                
                let nombre = document.createElement("td");
                nombre.innerHTML = obj2[x].nombre;
                tr.appendChild(nombre);
                
                let telefono = document.createElement("td");
                telefono.innerHTML = obj2[x].horasSemanales;
                tr.appendChild(telefono);
                
                let email = document.createElement("td");
                email.innerHTML = obj2[x].creditos;
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
                $('#tabla_de_cursos').DataTable({
                  "language": {
                        "lengthMenu": "Mostrar _MENU_ cursos",
                        "zeroRecords": "Sin resultados encontrados",
                        "info": "Mostrando _START_ a _END_ de _TOTAL_ cursos",
                        "infoEmpty": "Mostrando 0 to 0 of 0 cursos",
                        "infoFiltered": "(Filtrado de _MAX_ total cursos)",
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
    var table = $('#tabla_de_cursos').DataTable();
    table.destroy();
    var tableElement = document.getElementById('tabla_de_cursos');
    var oldTbody = document.getElementById("tbody_tabla_de_cursos");
    tableElement.removeChild(oldTbody);
    var newTbody = document.createElement('tbody');
    newTbody.id = 'tbody_tabla_de_cursos';
    tableElement.appendChild(newTbody);
    creartabla();


}
function clearparams(){
    document.getElementById('codigoCurso').value='';
    document.getElementById('nombreCurso').value='';
    document.getElementById('horasSemanales').value='';
    document.getElementById('creditosCurso').value='';
    
    
}

function eliminar(x){
    console.log('elimina: '+x);
//     var url = "../api/cursos/delete/"+x ;
    var aux = "../servletCursos?" +
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
            if(obj2===1)
                alert("curso eliminado con exito");
            else
                alert("fallo al eliminar curso ");
        });//second then
    
}

function guardar(){
    var codigoCurso = document.getElementById('codigoCurso').value;
    var nombreCurso = document.getElementById('nombreCurso').value;
    var horasSemanales = document.getElementById('horasSemanales').value;
    var creditosCurso = document.getElementById('creditosCurso').value;
    if((codigoCurso==="") ||(nombreCurso==="")||(horasSemanales==="")||(creditosCurso==="") ){
        alert("DEBE LLENAR TODOS LOS CAMPOS");
    }else{
        var aux = "../servletCursos?" +
                "codigoCurso={0}&nombreCurso={1}&horasSemanales={2}&creditosCurso={3}";
        var url = aux.format(
                codigoCurso, nombreCurso, horasSemanales,creditosCurso);
    //    var url = "../api/cursos/insert/"+codigoCurso+"/"+nombreCurso+"/"+horasSemanales+"/"+creditosCurso;
        fetch(url,{method: 'POST'}).then(r => {
       return r.json();
       }).then(d => {
           var obj = JSON.stringify(d);
           var obj2 = JSON.parse(obj);
           console.log(obj2);
           if(obj2 ==='insertado')
               alert("curso insertado");
           addrow();
           clearparams();
       }).catch(err => {
         console.log("Error Reading data " + err);
         alert("error al insertar curso");
         addrow();
         clearparams();
       });
    }
    
}

function update(x){
   var codigoCurso = document.getElementById('codigoCurso').value;
    var nombreCurso = document.getElementById('nombreCurso').value;
    var horasSemanales = document.getElementById('horasSemanales').value;
    var creditosCurso = document.getElementById('creditosCurso').value;
    if((codigoCurso==="") ||(nombreCurso==="")||(horasSemanales==="")||(creditosCurso==="") ){
        alert("DEBE LLENAR TODOS LOS CAMPOS");
    }else{
        var aux = "../servletCursos?" +
            "codigoCurso={0}&nombreCurso={1}&horasSemanales={2}&creditosCurso={3}&x={4}";
        var url = aux.format(
            codigoCurso, nombreCurso, horasSemanales,creditosCurso,x);
//       var url = "../api/cursos/update/"+codigoCurso+"/"+nombreCurso+"/"+horasSemanales+"/"+creditosCurso+"/"+x;
        console.log('URL:'+ url);
         fetch(url,{method: 'PUT'}).then(r => {
        return r.json();
        }).then(d => {
            var obj = JSON.stringify(d);
            var obj2 = JSON.parse(obj);
            console.log(obj2);
            if(obj2 === "actualizado con exito")
                alert(obj2);
            addrow();
            clearparams();
            salidModoEdicion();
        }).catch(err => {
          console.log("Error Reading data " + err);
          addrow();
          clearparams();
        });
    }
}


function editar(x){
    var curso = document.getElementById(x);
    var list = curso.childNodes;
    
    for(let i = 0; i< list.length-2;i++)
        console.log(curso.childNodes[i].innerHTML);
    
    document.getElementById('codigoCurso').value=curso.childNodes[0].innerHTML;
    document.getElementById('nombreCurso').value=curso.childNodes[1].innerHTML;
    document.getElementById('horasSemanales').value=curso.childNodes[2].innerHTML;
    document.getElementById('creditosCurso').value=curso.childNodes[3].innerHTML;
    
    
//    var form = document.getElementById('profesorForm');
//    form.action = "../api/profesores/update";
    
    var botonSalirModo = document.getElementById('salirModoEdicion');
    botonSalirModo.style.display = '';
    
    var botonSumit = document.getElementById('registrarCursoBoton');
    botonSumit.innerHTML = 'Editar Curso';
   document.getElementById("codigoCurso").disabled = true;
   botonSumit.onclick = function(){update(x);};
    // programar el otro boton para que revierta esos cambios
}

function salidModoEdicion(){
    clearparams();
    
//    var form = document.getElementById('profesorForm');
//    form.action = "../api/profesores/insert";
    
    var botonSalirModo = document.getElementById('salirModoEdicion');
    botonSalirModo.style.display = 'none';
    
    var botonSumit = document.getElementById('registrarCursoBoton');
    botonSumit.innerHTML = 'Registrar Cursos';
   document.getElementById("codigoCurso").disabled = false;
   botonSumit.onclick = function(){guardar();};
   
}

String.prototype.format = function () {
    var a = this;
    for (var k in arguments) {
        a = a.replace("{" + k + "}", arguments[k]);
    }
    return a;
};
