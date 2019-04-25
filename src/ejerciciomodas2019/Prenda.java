/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.text.Collator;

/**
 *
 * @author fer
 */
public class Prenda implements Comparable<Prenda>{

    private String codigo;
    private boolean especial;
    private TipoPrenda tipo;
    private Proveedor proveedor;
            
    public Prenda(String c, TipoPrenda t, boolean s, Proveedor p){
        this.codigo=c;
        this.especial=s;
        this.tipo=t;
        this.proveedor=p;
        
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public boolean isEspecial(){
        return this.especial;
    }
    
    public TipoPrenda getTipo(){
        return this.tipo;
    }
    
    public Proveedor getProveedor(){
        return this.proveedor;
    }
    
    @Override
    public int compareTo(Prenda o) {
        Collator alfabeto=Collator.getInstance();
        alfabeto.setStrength(Collator.PRIMARY);
        int[] criterios={alfabeto.compare(this.codigo, o.codigo),
                this.tipo.compareTo(o.tipo),
                this.proveedor.compareTo(o.proveedor)};
                
        for(int unCriterio: criterios){
            if(unCriterio != 0){
                return unCriterio;
            }
        }
        return 0;
    }
    
}
