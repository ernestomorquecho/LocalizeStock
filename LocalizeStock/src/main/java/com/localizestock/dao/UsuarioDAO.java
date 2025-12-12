package com.localizestock.dao;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.localizestock.model.Usuario;
import com.localizestock.util.AESUtil;

public class UsuarioDAO {
    
    private static final String RUTA_ARCHIVO = "/mnt/localizestock/usuarios/Usuarios.json";

    public List<Usuario> leerUsuarios() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File archivo = new File(RUTA_ARCHIVO);
            if (!archivo.exists()) return new ArrayList<>();

            byte[] bytesArchivo = Files.readAllBytes(archivo.toPath());
            String contenidoCifrado = new String(bytesArchivo).trim();
            String jsonPlano = AESUtil.desencriptar(contenidoCifrado);
            
            if (jsonPlano == null) return new ArrayList<>();

            Usuario[] lista = mapper.readValue(jsonPlano, Usuario[].class);
            return new ArrayList<>(List.of(lista));

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // --- NUEVO MÉTODO: GUARDAR (Registrar) ---
    public boolean guardarUsuario(Usuario nuevoUsuario) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // 1. Obtener lista actual
            List<Usuario> listaActual = leerUsuarios();
            
            // 2. Simular Auto-Incremento de ID\
            if (nuevoUsuario.getId_usuario() == 0) {
                int maxId = listaActual.stream().mapToInt(Usuario::getId_usuario).max().orElse(0);
                nuevoUsuario.setId_usuario(maxId + 1);
            }

            // 3. Agregar a la lista
            listaActual.add(nuevoUsuario);

            // 4. Convertir a JSON
            String jsonPlano = mapper.writeValueAsString(listaActual);

            // 5. Encriptar
            String contenidoCifrado = AESUtil.encriptar(jsonPlano);

            // 6. Guardar en Disco (NFS)
            File archivo = new File(RUTA_ARCHIVO);
            if (!archivo.getParentFile().exists()) {
                archivo.getParentFile().mkdirs();
            }
            Files.write(Paths.get(RUTA_ARCHIVO), contenidoCifrado.getBytes());

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}