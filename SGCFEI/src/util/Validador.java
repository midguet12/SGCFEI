/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Luis
 */
public class Validador {

    public boolean validarCorreo (String correo) {
        boolean esValidoCorreo;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        esValidoCorreo = mather.find();
        return esValidoCorreo;
    }

    public boolean validarNombre (String nombre) {
        boolean esValidoNombre;
        Pattern pattern = Pattern
                .compile("([A-Za-záéíóúüÁÉÍÓÚÜñÑ]{3,}(\\ [A-Za-záéíóúüÁÉÍÓÚÜñÑ]{3,})*)");
        Matcher mather = pattern.matcher(nombre);
        esValidoNombre = mather.find();
        return esValidoNombre;
    }

    public boolean numeroPersonal (String numeroPersonal) {
        boolean esValidoNumeroPersonal;
        Pattern pattern = Pattern
                .compile("([0-9]{8,10})");
        Matcher mather = pattern.matcher(numeroPersonal);
        esValidoNumeroPersonal = mather.find();
        return esValidoNumeroPersonal;
    } 
}
