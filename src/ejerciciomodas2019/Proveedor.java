package ejerciciomodas2019;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafa
 */
public class Proveedor implements Comparable<Proveedor>, Serializable{

    private String nombre;
    private String telefono;

    public Proveedor(String n, String t) {
        this.nombre = n;
        this.telefono = t;
    }

    public String getNombre() {

        return nombre;
    }

    public String getTelefono() {

        return telefono;
    }

    
    @Override
    public String toString(){
        return this.telefono+"-"+this.nombre;
    }
    
    @Override
    public int compareTo(Proveedor p) {
        return this.nombre.compareTo(p.nombre);
    }
}
