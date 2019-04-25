/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.util.ArrayList;

/**
 *
 * @author César
 */
public class Proveedor extends ArrayList<Proveedor>{
    private String nombre;
    private String telefono;

    public Proveedor(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Proveedor devuelveProveedor(String nombre){
        for (Proveedor uno : this) {
            if(uno.getNombre().equals(nombre)){
                return uno;
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    
}
