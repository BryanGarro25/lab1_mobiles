/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import BusinessLogic.Usuario;

/**
 *
 * @author Josue
 */
public class ServicioUsuario extends Servicio {
    private final Usuario usuario = new Usuario("lab01", "lab01");
    private static ServicioUsuario uniqueInstance;

    public static ServicioUsuario  instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ServicioUsuario();
        }
        return uniqueInstance;
    }
    public ServicioUsuario(){
        
    }
    public boolean login(Usuario usuario){
        return this.usuario.getPassword().equals(usuario.getPassword())&& this.usuario.getUsuario().equals(usuario.getUsuario());
    }
}
