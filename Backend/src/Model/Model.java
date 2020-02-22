/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Data.ServicioCurso;
import Data.ServicioProfesor;

/**
 *
 * @author Josue
 */
public class Model extends InterfaceModel{

    private ServicioCurso servicioCurso;
    private ServicioProfesor servicioProfesor;

    private static Model uniqueInstance;

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model() {
            };
        }
        return uniqueInstance;
    }
     private Model(){
        servicioCurso= new ServicioCurso();
        servicioProfesor= new ServicioProfesor();
        
    }
}
