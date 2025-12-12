package com.localizestock.model;

public class Consulta {
    private int id_consulta;
    private int id_usuario;
    private String termino_busqueda; 
    private String fecha; 

    public Consulta() {}

    public Consulta(int id_consulta, int id_usuario, String termino_busqueda, String fecha) {
        this.id_consulta = id_consulta;
        this.id_usuario = id_usuario;
        this.termino_busqueda = termino_busqueda;
        this.fecha = fecha;
    }

    public int getId_consulta() { return id_consulta; }
    public void setId_consulta(int id_consulta) { this.id_consulta = id_consulta; }
    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }
    public String getTermino_busqueda() { return termino_busqueda; }
    public void setTermino_busqueda(String termino_busqueda) { this.termino_busqueda = termino_busqueda; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}