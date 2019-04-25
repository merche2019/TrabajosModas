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
public class Prenda implements Comparable<Prenda>, Serializable{
    private String codigo;
    private boolean especial;
    private TipoPrenda tipoPrenda;
    private Proveedor proveedor;
    
    
    
    public Prenda(String c, TipoPrenda t, boolean e, Proveedor p){
        this.codigo= c;
        this.tipoPrenda= t;
        this.especial= e;
        this.proveedor= p;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public Proveedor getElProveedor(){
        return this.proveedor;
    }
    
    public boolean isEspecial(){
        return this.especial;
    }
    
    public TipoPrenda getTipo(){
        return this.tipoPrenda;
    }
    
    public int compareTo(Prenda o){
        return this.getCodigo().compareTo(o.getCodigo());
    }
}
