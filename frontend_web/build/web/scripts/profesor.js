/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function creartabla(){
        var url = "../api/profesores/all";
      
        fetch(url).then(r => {
            return r.json();
        }).then(d => {
            var obj = JSON.stringify(d);
            var obj2 = JSON.parse(obj);
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
                
                tbody.appendChild(tr);
            }
            
            
            $(document).ready(function() {
                $('#tabla_de_profesores').DataTable({
                  "language": {
                        "lengthMenu": "Mostrar _MENU_ Entradas",
                        "zeroRecords": "Sin resultados encontrados",
                        "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
                        "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
                        "infoFiltered": "(Filtrado de _MAX_ total entradas)",
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
                }
        
            );});
        
        
        });
    
}

function addrow() {
    $('#tabla_de_profesores').dataTable().fnAddData( [
        $('#inputcedulaProfesor').val(),
        $('#nombreProfesor').val(),
        $('#telefonoProfesor').val(),
        $('#emailProfesor').val() ] );

}
function clearparams(){
    document.getElementById('inputcedulaProfesor').value='';
    document.getElementById('nombreProfesor').value='';
    document.getElementById('telefonoProfesor').value='';
    document.getElementById('emailProfesor').value='';
    
    
}