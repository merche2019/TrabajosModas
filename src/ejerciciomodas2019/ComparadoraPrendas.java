/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.text.Collator;
import java.util.Comparator;

/**
 *
 * @author fer
 */
public class ComparadoraPrendas implements Comparator <Prenda> {

    @Override
    public int compare(Prenda o1, Prenda o2) {
        Collator alfabeto=Collator.getInstance();
        alfabeto.setStrength(Collator.PRIMARY);
        int[] criterios={o1.getTipo().compareTo(o2.getTipo()),
        alfabeto.compare(o1.getCodigo(), o2.getCodigo()),
        o1.getProveedor().compareTo(o2.getProveedor())};
        
        for(int criterio: criterios){
            if(criterio != 0){
                return criterio;
                return 0;
    }
}
