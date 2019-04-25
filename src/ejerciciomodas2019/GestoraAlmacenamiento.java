/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fer
 */
public class GestoraAlmacenamiento {
    private static final String FILE="prendas.dat";
    static boolean escribirDatos(Object objeto){
        try (ObjectOutputStream escritor=new ObjectOutputStream(new FileOutputStream(FILE))){
            escritor.writeObject(objeto);
            return true;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraAlmacenamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestoraAlmacenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false; 
    }
    static Object leerDatos(){
        try(ObjectInputStream lector=new ObjectInputStream(new FileInputStream(FILE))){
            return lector.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraAlmacenamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestoraAlmacenamiento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestoraAlmacenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
}

