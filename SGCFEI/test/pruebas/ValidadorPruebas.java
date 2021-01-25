package pruebas;

import org.junit.Test;
import static org.junit.Assert.*;
import util.Validador;

public class ValidadorPruebas {    
    public ValidadorPruebas() {
    }
    
    @Test
    public void validarCorreo(){
        assertEquals(true, Validador.validarCorreo("prueba@prueba.com"));

    }
    
    @Test
    public void validarCorreoFalso(){
        assertEquals(false, Validador.validarCorreo("prueba@prueba"));
    }
    
    @Test
    public void validarNombre(){
        assertEquals(true, Validador.validarNombre("Pancho Villa"));
    }
    
    @Test
    public void validarNombreFalso(){
        assertEquals(false, Validador.validarCorreo("p*nch0 v1//a"));
    }
    
    @Test
    public void validarnNumeroPersonal(){
        assertEquals(true, Validador.numeroPersonal("45632459"));
    }
    
    @Test
    public void validarNumeroPersonalFalso(){
        assertEquals(false, Validador.numeroPersonal("4*/S122"));
    }
    
    @Test
    public void validarNumero(){
        assertEquals(true, Validador.numero("45"));
    }
    
    @Test
    public void validarNumeroFalso(){
        assertEquals(false, Validador.numero("/.*"));
    }
}
