package com.localizestock.model;

public class Tienda {
    private int id_tienda;
    private String nombre;
    private String direccion;
    private int id_ubicacion; 

    public Tienda() {}

    public Tienda(int id_tienda, String nombre, String direccion, int id_ubicacion) {
        this.id_tienda = id_tienda;
        this.nombre = nombre;
        this.direccion = direccion;
        this.id_ubicacion = id_ubicacion;
    }

    // Getters y Setters
    public int getId_tienda() { return id_tienda; }
    public void setId_tienda(int id_tienda) { this.id_tienda = id_tienda; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public int getId_ubicacion() { return id_ubicacion; }
    public void setId_ubicacion(int id_ubicacion) { this.id_ubicacion = id_ubicacion; }
}