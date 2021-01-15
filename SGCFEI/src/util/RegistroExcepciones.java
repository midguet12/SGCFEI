package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class RegistroExcepciones {
    public static void escribirExcepcion (Exception ex, String nombreArchivo){
        FileWriter archivo = null;
        PrintWriter escribirArchivo;
        LocalDateTime tiempoAhora;

        try{
            archivo = new FileWriter("error.log", true);
            escribirArchivo = new PrintWriter(archivo);
            tiempoAhora = LocalDateTime.now();
            
            escribirArchivo.println(nombreArchivo + ": " + tiempoAhora + " - " +  ex.toString());
        } 
        catch (IOException exeption) {
             System.out.println(exeption.getMessage());
        } 
        finally {
            try {
                if (null != archivo){
                    archivo.close();
                }
            } 
            catch (IOException exeption) {
                System.out.println(exeption.getMessage());
            } 
        }
    }

}
