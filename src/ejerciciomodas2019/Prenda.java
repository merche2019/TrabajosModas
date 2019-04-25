package ejerciciomodas2019;


import java.io.Serializable;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafa
 */
public class Prenda implements Comparable<Prenda>, Serializable{
    private String codigo;
    private boolean especial;
    private TipoPrenda tipoPrenda;
    private Proveedor elProveedor;
    
    public Prenda(String c, TipoPrenda t, boolean e, Proveedor p){
        this.codigo = c;
        this.tipoPrenda=t;
        this.especial=e;
        this.elProveedor=p;
    }
    
    public String getCodigo(){
        
        return codigo;
    }
    
    public Proveedor getElProveedor(){
        
        return elProveedor;
    }
    
    public boolean isEspecial(){
        return especial;
    }
    
    public TipoPrenda getTipo(){
        return tipoPrenda;
    }
    
    public int compareTo(Prenda o){
        return this.getCodigo().compareTo(o.getCodigo());
    }
}
