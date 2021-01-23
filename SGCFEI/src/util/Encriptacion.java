/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class Encriptacion {
    private static final String SHA_256_FUNCTION = "SHA-256";
    private static final String MD5_FUNCTION = "MD5";

    /***
     * This method crypt any text in SHA256
     * <p>
     * It's used when someone needs to crypt some text.
     * In this system, the use that is given is for Auth module.
     * </p>
     * @param string
     * @return String encrypted.
     */
    public static String encriptarSHA2(String string) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(SHA_256_FUNCTION);
        } catch (NoSuchAlgorithmException e) {
            RegistroExcepciones.escribirExcepcion(e, Encriptacion.class.getName());
        }
        byte[] array = messageDigest.digest(string.getBytes());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            stringBuffer.append( Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3) );
        }
        return stringBuffer.toString();
    }

    /***
     * This method crypt any text in SHA256
     * <p>
     * It's used when someone needs to crypt some text.
     * In this system, the use that is given is for Auth module.
     * </p>
     * @param string
     * @return String encrypted
     */
    public static String encriptarMD5(String string) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(MD5_FUNCTION);
        } catch (NoSuchAlgorithmException e) {
            RegistroExcepciones.escribirExcepcion(e, Encriptacion.class.getName());
        }
        byte[] array = messageDigest.digest(string.getBytes());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            stringBuffer.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
        }
        return stringBuffer.toString();
    }

    /***
     * This method crypt a random number.
     * <p>
     * The purpose is generate a "random password" encrypted.
     * </p>
     * @return String encrypted in MD5
     */
    public static String generarContraseñaAleatoria() {
        return encriptarMD5(String.valueOf( Math.random() ) );
    }
}
