package com.localizestock.dao;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.localizestock.model.Tienda;
import com.localizestock.util.AESUtil;

public class TiendaDAO {
    private static final String RUTA = "/mnt/localizestock/tiendas/tiendas.json";

    public List<Tienda> leerTiendas() {
        try {
            File archivo = new File(RUTA);
            if (!archivo.exists()) return new ArrayList<>();
            
            String jsonPlano = AESUtil.desencriptar(new String(Files.readAllBytes(archivo.toPath())).trim());
            if (jsonPlano == null) return new ArrayList<>();

            return List.of(new ObjectMapper().readValue(jsonPlano, Tienda[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}