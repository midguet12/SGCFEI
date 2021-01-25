package pruebas;

import java.sql.Connection;
import database.ConexionDB;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConexionDBPruebas {
    private ConexionDB db;
    
    public ConexionDBPruebas() {
        db = new ConexionDB();
    }
    
    @Test
    public void iniciarConexion(){
        Connection conexion = db.obtenerConexion();

        assertNotNull(conexion);
    }
    
    @Test
    public void cerrarConexion() throws SQLException{
        Connection conexion = db.obtenerConexion();
        db.cerrarConexion();
        
        assertNotNull(conexion.isClosed());
    }    
}
