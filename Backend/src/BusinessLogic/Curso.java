/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

/**
 *
 * @author Josue
 */
public class Curso {
    private int id;
    private String codigo;
    private String nombre;
    private int creditos;
    private int horasSemanales;
    
    public Curso(){
        this.id = 0;
        this.codigo = new String();
        this.nombre = new String();
        this.creditos = 0;
        this.horasSemanales = 0;
    }

    public Curso(int id, String codigo, String nombre, int creditos, int horasSemanales) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nombre=" + nombre + ", creditos=" + creditos + ", horasSemanales=" + horasSemanales + '}';
    }
}
