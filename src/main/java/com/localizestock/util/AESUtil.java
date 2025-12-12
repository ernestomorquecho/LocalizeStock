package com.localizestock.util;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
    private static final String LLAVE = "LocalizeStock123"; 

    public static String encriptar(String datos) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(LLAVE.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(datos.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String desencriptar(String datosEncriptados) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(LLAVE.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(datosEncriptados)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}