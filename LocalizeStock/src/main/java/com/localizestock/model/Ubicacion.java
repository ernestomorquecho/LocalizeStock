package com.localizestock.model;

public class Ubicacion {
    private int id_ubicacion;
    private double latitud;
    private double longitud;

    public Ubicacion() {}

    public Ubicacion(int id_ubicacion, double latitud, double longitud) {
        this.id_ubicacion = id_ubicacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getId_ubicacion() { return id_ubicacion; }
    public void setId_ubicacion(int id_ubicacion) { this.id_ubicacion = id_ubicacion; }
    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }
}