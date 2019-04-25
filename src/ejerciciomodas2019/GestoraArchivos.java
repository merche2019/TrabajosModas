package ejerciciomodas2019;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego
 */
public class GestoraArchivos {
	
	private static String FILE_NAME= "datos.dat";

	public static boolean guardarDatos()
	{
		try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(GestoraArchivos.FILE_NAME)))
		{
			escritor.writeObject(GestoraInformacion.getInstance());
			return true;
		} catch (FileNotFoundException ex) {
			Logger.getLogger(GestoraArchivos.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(GestoraArchivos.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public static GestoraInformacion cargarDatos()
	{
		try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream(GestoraArchivos.FILE_NAME)))
		{
			return (GestoraInformacion)lector.readObject();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(GestoraArchivos.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException | ClassNotFoundException ex) {
			Logger.getLogger(GestoraArchivos.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
