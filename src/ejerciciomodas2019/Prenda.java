/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;


/**
 *
 * @author Usuario
 */
public class Prenda {
    private String codigo;
    private TipoPrenda tipo;
    private boolean especial;
    private Proveedor elProveedor;

    public Prenda(String codigo, TipoPrenda tipo, boolean especial, Proveedor elProveedor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.especial = especial;
        this.elProveedor = elProveedor;
    }
    
    
    

    public Prenda(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    
    public Proveedor getElProveedor() {
        return elProveedor;
    }

    public boolean isEspecial(){
        
        return true;
    }

    public TipoPrenda getTipo() {
        return tipo;
    }
    
    public int compareTo(Prenda o){
        
        return 0;
    }
    
}
