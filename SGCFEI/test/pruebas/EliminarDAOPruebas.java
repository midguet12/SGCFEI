package pruebas;

import accesodatos.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import util.obtenerID;

public class EliminarDAOPruebas {
    obtenerID oid;
    
    public EliminarDAOPruebas() {
        oid = new obtenerID();
    }
    
    @Test
    public void eliminarAcademia(){
        AcademiaDAO dao = new AcademiaDAO();

        assertEquals(true, dao.eliminar(oid.obtenerIDAcademia("PRUEBAPRUEBA")));
    }
    
    @Test
    public void eliminarAcademico(){
        AcademicoDAO dao = new AcademicoDAO();

        assertEquals(true, dao.eliminar(oid.obtenerIDAcademico("PRUEBAPRUEBA")));
    }
    
    @Test
    public void eliminarCarrera(){
        CarreraDAO dao = new CarreraDAO();

        assertEquals(true, dao.eliminar(oid.obtenerIDCarrera("PRUEBAPRUEBA")));
    }
    
    @Test
    public void eliminarCuerpoAcademico(){
        CuerpoAcademicoDAO dao = new CuerpoAcademicoDAO();

        assertEquals(true, dao.eliminar(oid.obtenerIDCuerpoAcademico("PRUEBAPRUEBA")));
    }
    
    @Test
    public void eliminarExperienciaEducativa(){
        ExperienciaEducativaDAO dao = new ExperienciaEducativaDAO();

        assertEquals(true, dao.eliminar(oid.obtenerIDExperienciaEducativa("PRUEBAPRUEBA")));
    }
    
    @Test
    public void eliminarFacultad(){
        FacultadDAO dao = new FacultadDAO();
;
        assertEquals(true, dao.eliminar(oid.obtenerIDFacultad("PRUEBAPRUEBA")));
    }
    
    @Test
    public void eliminarLGCA(){
        LGCADAO dao = new LGCADAO();
        
        assertEquals(true, dao.eliminar(oid.obtenerIDlgca("PRUEBAPRUEBA")));
    }
    
    @Test
    public void eliminarUsuario(){
        UsuarioDAO dao = new UsuarioDAO();
        
        assertEquals(true, dao.eliminar(dao.obtener("PRUEBAPRUEBA").getIdAcademico()));
    }
}
