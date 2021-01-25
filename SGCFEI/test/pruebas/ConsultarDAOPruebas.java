package pruebas;

import accesodatos.*;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import util.obtenerID;

public class ConsultarDAOPruebas {
    obtenerID oid;
    
    public ConsultarDAOPruebas() {
        oid = new obtenerID();
    }
    
    @Test
    public void obtenerAcademia(){
        AcademiaDAO dao = new AcademiaDAO();

        assertNotNull(dao.obtener(oid.obtenerIDAcademia("PRUEBAPRUEBA")));
    }
    
    @Test
    public void obtenerAcademico(){
        AcademicoDAO dao = new AcademicoDAO();

        assertNotNull(dao.obtener(oid.obtenerIDAcademico("PRUEBAPRUEBA")));
    }
    
    @Test
    public void obtenerCarrera(){
        CarreraDAO dao = new CarreraDAO();

        assertNotNull(dao.obtener(oid.obtenerIDCarrera("PRUEBAPRUEBA")));
    }
    
    @Test
    public void obtenerCuerpoAcademico(){
        CuerpoAcademicoDAO dao = new CuerpoAcademicoDAO();

        assertNotNull(dao.obtener(oid.obtenerIDCuerpoAcademico("PRUEBAPRUEBA")));
    }
    
    @Test
    public void obtenerExperienciaEducativa(){
        ExperienciaEducativaDAO dao = new ExperienciaEducativaDAO();

        assertNotNull(dao.obtener(oid.obtenerIDExperienciaEducativa("PRUEBAPRUEBA")));
    }
    
    @Test
    public void obtenerFacultad(){
        FacultadDAO dao = new FacultadDAO();
;
        assertNotNull(dao.obtener(oid.obtenerIDFacultad("PRUEBAPRUEBA")));
    }
    
    @Test
    public void obtenerLGCA(){
        LGCADAO dao = new LGCADAO();
        
        assertNotNull(dao.obtener(oid.obtenerIDlgca("PRUEBAPRUEBA")));
    }
    
    @Test
    public void obtenerUsuario(){
        UsuarioDAO dao = new UsuarioDAO();

        assertNotNull(dao.obtener(dao.obtener("PRUEBAPRUEBA").getIdUsuario()));
    }
}
