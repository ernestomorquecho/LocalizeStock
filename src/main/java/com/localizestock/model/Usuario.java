package com.localizestock.model;

public class Usuario {
    private int id_usuario;
    private String nombre;
    private String email;

    public Usuario() {}

    public Usuario(int id_usuario, String nombre, String email) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}