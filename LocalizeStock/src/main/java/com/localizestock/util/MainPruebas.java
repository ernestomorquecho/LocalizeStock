package com.localizestock.util;

public class MainPruebas {
    public static void main(String[] args) {

    	// JSON de prueba para usuarios
    	String jsonOriginal = "[{\"id_usuario\":1, \"nombre\":\"Juan Perez\", \"email\":\"juan@uaa.mx\"}, {\"id_usuario\":2, \"nombre\":\"Maria Lopez\", \"email\":\"maria@uaa.mx\"}]";
    	
        String encriptado = AESUtil.encriptar(jsonOriginal);
        System.out.println("Copia este texto y guardalo en tu archivo:");
        System.out.println(encriptado);
    }
}