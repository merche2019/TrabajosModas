/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

/**
 *
 * @author Alex
 */
public class Proveedor {
    private String nombre;
    private String telefono;
    
    
    public Proveedor(String n, String t){
        this.nombre = n.toUpperCase();
        this.telefono = t;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public String toString(){
        return String.format("%d-$s", this.telefono, this.nombre);
    }
    
}
