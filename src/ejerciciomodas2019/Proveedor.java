/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.io.Serializable;

/**
 *
 * @author Tarod
 */
public class Proveedor implements Serializable {
    private String nombre;
    private String telefono;

    public Proveedor(String nombre, String telefono) {
        this.nombre = nombre.toUpperCase();
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String toString() {
        return String.format("%s-%s", this.telefono, this.nombre);
    }
}
