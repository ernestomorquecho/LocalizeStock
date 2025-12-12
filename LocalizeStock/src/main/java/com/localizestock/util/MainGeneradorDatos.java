package com.localizestock.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.localizestock.model.*;

public class MainGeneradorDatos {

    private static final String RUTA_BASE = "/mnt/localizestock/"; 

    public static void main(String[] args) {
        System.out.println("--- INICIANDO GENERACIÓN DE DATOS CIFRADOS ---");

        try {
            generarUsuarios();
            generarProductos();
            generarTiendas();
            generarUbicaciones();
            generarInventario();
            generarConsultas();
            
            System.out.println("--- ¡PROCESO TERMINADO CON ÉXITO! ---");
            System.out.println("Verifica las carpetas en: " + RUTA_BASE);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("ERROR: Asegúrate de que las carpetas existan o cambia la RUTA_BASE en este código.");
        }
    }

    private static void guardarArchivo(String subcarpeta, String nombreArchivo, Object listaObjetos) throws Exception {
        // 1. Convertir Objetos a JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonPlano = mapper.writeValueAsString(listaObjetos);
        
        System.out.println("\nProcesando: " + nombreArchivo);
        System.out.println("Datos planos: " + jsonPlano);

        // 2. Encriptar
        String contenidoCifrado = AESUtil.encriptar(jsonPlano);

        String rutaCompleta = RUTA_BASE + subcarpeta + "/" + nombreArchivo;
        File archivo = new File(rutaCompleta);
        
        archivo.getParentFile().mkdirs(); 

        Files.write(Paths.get(rutaCompleta), contenidoCifrado.getBytes());
        System.out.println("-> Archivo GUARDADO y CIFRADO en: " + rutaCompleta);
    }

    private static void generarUsuarios() throws Exception {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario(1, "Admin Localize", "admin@localizestock.com"));
        lista.add(new Usuario(2, "Cliente Prueba", "cliente@gmail.com"));
        guardarArchivo("usuarios", "Usuarios.json", lista);
    }

    private static void generarProductos() throws Exception {
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto(101, "Leche Entera Lala 1L", "Lácteos"));
        lista.add(new Producto(102, "Pan Bimbo Blanco", "Panadería"));
        lista.add(new Producto(103, "Coca Cola 600ml", "Bebidas"));
        guardarArchivo("productos", "productos.json", lista);
    }

    private static void generarTiendas() throws Exception {
        List<Tienda> lista = new ArrayList<>();
        lista.add(new Tienda(1, "Walmart Centro", "Av. Adolfo Lopez Mateos 100", 1));
        lista.add(new Tienda(2, "Oxxo Colosio", "Av. Colosio 200", 2));
        guardarArchivo("tiendas", "tiendas.json", lista);
    }

    private static void generarUbicaciones() throws Exception {
        List<Ubicacion> lista = new ArrayList<>();
        // Coordenadas reales aproximadas de Aguascalientes
        lista.add(new Ubicacion(1, 21.88234, -102.28259)); // Centro
        lista.add(new Ubicacion(2, 21.91234, -102.30259)); // Norte
        guardarArchivo("ubicaciones", "ubicaciones.json", lista);
    }

    private static void generarInventario() throws Exception {
        List<Inventario> lista = new ArrayList<>();
        lista.add(new Inventario(1, 101, 1, 50, 28.50));
        lista.add(new Inventario(2, 102, 1, 30, 45.00));

        lista.add(new Inventario(3, 103, 2, 100, 18.00));
        guardarArchivo("inventario", "inventario.json", lista);
    }

    private static void generarConsultas() throws Exception {
        List<Consulta> lista = new ArrayList<>();
        lista.add(new Consulta(1, 2, "Leche", "2025-11-01T10:00:00"));
        guardarArchivo("consultas", "consultas.json", lista);
    }
}