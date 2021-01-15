//TODO Tratar excepciones
package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import util.RegistroExcepciones;

public class ControladorCredenciales {
    public static DBCredenciales leer(){
        String archivo = "db.conf";
        DBCredenciales credenciales = null;
        
        try{
            FileInputStream archivoFuente = new FileInputStream(archivo);
            ObjectInputStream reader = new ObjectInputStream(archivoFuente);
            
            credenciales = (DBCredenciales)reader.readObject();
            
            
        } catch(IOException | ClassNotFoundException ex){
            RegistroExcepciones.escribirExcepcion(ex, "ControladorCredenciales");
        }
        
        return credenciales;   
    }
    
    public static void escribir(DBCredenciales credenciales){
        String archivo = "db.conf";
        
        try {
            ObjectOutputStream writer;
            try (FileOutputStream archivoDestino = new FileOutputStream(archivo)) {
                writer = new ObjectOutputStream(archivoDestino);
                writer.writeObject(credenciales);
            }
            writer.close();    
        }
        catch (IOException ex) {
            RegistroExcepciones.escribirExcepcion(ex, "ControladorCredenciales");
        }        
    }
}
