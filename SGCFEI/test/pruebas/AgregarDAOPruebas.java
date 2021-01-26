package pruebas;

import accesodatos.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pojos.*;

public class AgregarDAOPruebas {  
    public AgregarDAOPruebas() {
    }
    
    @Test
    public void insertarAcademia(){
        AcademiaDAO dao = new AcademiaDAO();
        Academia item = new Academia(0, "PRUEBAPRUEBA", "", "00000001");
        
        assertEquals(true, dao.insertar(item));
    }
    
    @Test
    public void insertarAcademico(){
        AcademicoDAO dao = new AcademicoDAO();
        Academico item = new Academico("99999999", "PRUEBAPRUEBA", "", "00000001");
        
        assertEquals(true, dao.insertar(item));
    }
    
    @Test
    public void insertarCarrera(){
        CarreraDAO dao = new CarreraDAO();
        Carrera item = new Carrera("PRUEBAPRUEBA", 1);
        
        assertEquals(true, dao.insertar(item));
    }
    
    @Test
    public void insertarCuerpoAcademico(){
        CuerpoAcademicoDAO dao = new CuerpoAcademicoDAO();
        CuerpoAcademico item = new CuerpoAcademico("PRUEBAPRUEBA", "00000001");
        
        assertEquals(true, dao.insertar(item));
    }
    
    @Test
    public void insertarExperienciaEducativa(){
        ExperienciaEducativaDAO dao = new ExperienciaEducativaDAO();
        ExperienciaEducativa item = new ExperienciaEducativa(99899, "PRUEBAPRUEBA", 4);
        
        assertEquals(true, dao.insertar(item));
    }
    
    @Test
    public void insertarFacultad(){
        FacultadDAO dao = new FacultadDAO();
        Facultad item = new Facultad("PRUEBAPRUEBA");
        
        assertEquals(true, dao.insertar(item));
    }
    
    @Test
    public void insertarLGCA(){
        LGCADAO dao = new LGCADAO();
        LGCA item = new LGCA(43, "PRUEBAPRUEBA");
        
        assertEquals(true, dao.insertar(item));
    }
    
    @Test
    public void insertarUsuario(){
        UsuarioDAO dao = new UsuarioDAO();
        Usuario item = new Usuario("PRUEBAPRUEBA", "ASDASD", "564");
        
        assertEquals(true, dao.insertar(item));
    }
}
