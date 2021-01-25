package pruebas;

import org.junit.Test;
import static org.junit.Assert.*;
import util.Encriptacion;

public class EncriptacionPruebas {
    
    public EncriptacionPruebas() {
    }
    
    @Test
    public void encriptacion(){
        assertEquals("e633f4fc79badea1dc5db970cf397c8248bac47cc3acf9915ba60b5d76b0e88f", Encriptacion.encriptarSHA2("Hola"));
    }
    @Test
    public void encriptacionFalla(){
        assertNotEquals("633f4fc79badea1dc5db970cf397c8248bac47cc3acf9915ba60b5d76b0e88f", Encriptacion.encriptarSHA2("Hola"));
    }
}
