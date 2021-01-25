package pruebas;

import accesodatos.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pojos.*;
import util.obtenerID;

public class EditarDAOPruebas {
    obtenerID oid;
    
    public EditarDAOPruebas() {
        oid = new obtenerID();
    }
        @Test
    public void actualizarAcademia(){
        AcademiaDAO dao = new AcademiaDAO();
        Academia item = new Academia(oid.obtenerIDAcademia("PRUEBAPRUEBA"), "PRUEBAPRUEBA", "", "00000001");

        assertEquals(true, dao.actualizar(item));
    }
    
    @Test
    public void actualizarAcademico(){
        AcademicoDAO dao = new AcademicoDAO();
        Academico item = new Academico(oid.obtenerIDAcademico("PRUEBAPRUEBA"), "PRUEBAPRUEBA", "XD", "00000001");

        assertEquals(true, dao.actualizar(item));
    }
    
    @Test
    public void actualizarCarrera(){
        CarreraDAO dao = new CarreraDAO();
        Carrera item = new Carrera(oid.obtenerIDCarrera("PRUEBAPRUEBA"),"PRUEBAPRUEBA", 1);

        assertEquals(true, dao.actualizar(item));
    }
    
    @Test
    public void actualizarCuerpoAcademico(){
        CuerpoAcademicoDAO dao = new CuerpoAcademicoDAO();
        CuerpoAcademico item = new CuerpoAcademico(oid.obtenerIDCuerpoAcademico("PRUEBAPRUEBA"), "PRUEBAPRUEBA", "00000001");

        assertEquals(true, dao.actualizar(item));
    }
    
    @Test
    public void actualizarExperienciaEducativa(){
        ExperienciaEducativaDAO dao = new ExperienciaEducativaDAO();
        ExperienciaEducativa item = new ExperienciaEducativa(oid.obtenerIDExperienciaEducativa("PRUEBAPRUEBA"), "PRUEBAPRUEBA", 4);

        assertEquals(true, dao.actualizar(item));
    }
    
    @Test
    public void actualizarFacultad(){
        FacultadDAO dao = new FacultadDAO();
        Facultad item = new Facultad(oid.obtenerIDFacultad("PRUEBAPRUEBA"), "PRUEBAPRUEBA");
;
        assertEquals(true, dao.actualizar(item));
    }
    
    @Test
    public void actualizarLGCA(){
        LGCADAO dao = new LGCADAO();
        LGCA item = new LGCA(oid.obtenerIDlgca("PRUEBAPRUEBA"),43, "PRUEBAPRUEBA");

        assertEquals(true, dao.actualizar(item));
    }
    
    @Test
    public void actualizarUsuario(){
        UsuarioDAO dao = new UsuarioDAO();
        Usuario item = new Usuario(dao.obtener("PRUEBAPRUEBA").getIdUsuario(),"PRUEBAPRUEBA", "ASDASD", "564");
        
        assertEquals(true, dao.actualizar(item));
    }
}
