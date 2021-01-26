package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    public static boolean validarCorreo (String correo) {
        boolean esValidoCorreo;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        esValidoCorreo = mather.find();
        return esValidoCorreo;
    }

    public static boolean validarNombre (String nombre) {
        boolean esValidoNombre;
        Pattern pattern = Pattern
                .compile("([A-Za-záéíóúüÁÉÍÓÚÜñÑ]{3,15}(\\ [A-Za-záéíóúüÁÉÍÓÚÜñÑ]{3,15})*)");
        Matcher mather = pattern.matcher(nombre);
        esValidoNombre = mather.find();
        return esValidoNombre;
    }

    public static boolean numeroPersonal (String numeroPersonal) {
        boolean esValidoNumeroPersonal;
        Pattern pattern = Pattern
                .compile("([0-9]{8,10})");
        Matcher mather = pattern.matcher(numeroPersonal);
        esValidoNumeroPersonal = mather.find();
        return esValidoNumeroPersonal;
    }
    public static boolean numero (String numero) {
        boolean esValidoNumeroPersonal;
        Pattern pattern = Pattern
                .compile("([0-9])");
        Matcher mather = pattern.matcher(numero);
        esValidoNumeroPersonal = mather.find();
        return esValidoNumeroPersonal;
    } 

    public static boolean validarContraseña(String contraseña) {
        boolean esValidaContraseña;
        Pattern pattern = Pattern
                .compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])([A-Za-z\\d$@$!%*?&]|[^ ]){8,15}$");
        Matcher mather = pattern.matcher(contraseña);
        esValidaContraseña = mather.find();
        return esValidaContraseña;
    }
    
    public static boolean validarPeriodo(String periodo){
        boolean esValidoPeriodo;
        Pattern pattern = Pattern
                .compile("([A-Z]{3}\\ [0-9]{4})\\ \\-\\ ([A-Z]{3}\\ [0-9]{4})");
        Matcher mather = pattern.matcher(periodo);
        esValidoPeriodo = mather.find();
        return esValidoPeriodo;
    }
}
