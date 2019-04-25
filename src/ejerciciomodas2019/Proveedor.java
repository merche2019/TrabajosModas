/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

/**
 *
 * @author fer
 */
public class Proveedor {
    private String nombre;
    private String telefono;
    
    public Proveedor(String n, String t){
        this.nombre=n;
        this.telefono=t;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    int compareTo(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
