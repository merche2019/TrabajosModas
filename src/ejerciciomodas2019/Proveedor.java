/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.io.Serializable;

/**
 *
 * @author didi
 */
public class Proveedor implements  Comparable<Proveedor>, Serializable{
    private String nombre;
    private String telefono;
    
    public Proveedor(String n, String t){
        this.nombre= n;
        this.telefono= t;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    @Override
    public String toString() {
        return this.telefono + "-" +this.nombre;
    }

    @Override
    public int compareTo(Proveedor o) {
        return this.nombre.compareTo(o.nombre);
    }
}
