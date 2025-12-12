package com.localizestock.model;

public class Inventario {
    private int id_inventario;
    private int id_producto; 
    private int id_tienda;
    private int cantidad;
    private double precio;

    public Inventario() {}

    public Inventario(int id_inventario, int id_producto, int id_tienda, int cantidad, double precio) {
        this.id_inventario = id_inventario;
        this.id_producto = id_producto;
        this.id_tienda = id_tienda;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId_inventario() { return id_inventario; }
    public void setId_inventario(int id_inventario) { this.id_inventario = id_inventario; }
    public int getId_producto() { return id_producto; }
    public void setId_producto(int id_producto) { this.id_producto = id_producto; }
    public int getId_tienda() { return id_tienda; }
    public void setId_tienda(int id_tienda) { this.id_tienda = id_tienda; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}