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
 * @author Tarod
 */
public class GestoraAlmacenamiento {
    
    private static final String FILE = "informacion.dat";
    
    public static boolean guardarDatos() {
        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(FILE))) {
            escritor.writeObject(GestoraInformacion.getInstance());
            return true;
        } catch (IOException ex) {
            Logger.getLogger(GestoraAlmacenamiento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static GestoraInformacion leerDatos() {
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(FILE))) {
            return (GestoraInformacion) lector.readObject();
        } catch (FileNotFoundException ex) {
            return null;
        } catch (ClassNotFoundException | IOException ex) {
            return null;
        }
    }
    
}
