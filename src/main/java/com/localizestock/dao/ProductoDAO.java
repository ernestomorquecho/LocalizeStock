package com.localizestock.dao;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.localizestock.model.Producto;
import com.localizestock.util.AESUtil;

public class ProductoDAO {
    // Ruta al NFS
    private static final String RUTA_ARCHIVO = "/mnt/localizestock/productos/productos.json";

    public List<Producto> leerProductos() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File archivo = new File(RUTA_ARCHIVO);
            if (!archivo.exists()) return new ArrayList<>();

            // 1. Leer bytes crudos
            byte[] bytes = Files.readAllBytes(archivo.toPath());
            String contenido = new String(bytes).trim();

            if (contenido.isEmpty()) return new ArrayList<>();

            // 2. Desencriptar
            String jsonPlano = AESUtil.desencriptar(contenido);
            
            // 3. Convertir a Objetos
            if (jsonPlano != null) {
                return Arrays.asList(mapper.readValue(jsonPlano, Producto[].class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}