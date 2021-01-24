package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptacion {
    private static final String SHA_256_FUNCTION = "SHA-256";
    private static final String MD5_FUNCTION = "MD5";

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

    public static String generarContraseñaAleatoria() {
        return encriptarMD5(String.valueOf( Math.random() ) );
    }
}
