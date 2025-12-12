package com.localizestock.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.localizestock.dao.UbicacionDAO;
import com.localizestock.model.Ubicacion;

@Path("/ubicaciones")
public class UbicacionService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ubicacion> getUbicaciones() {
        return new UbicacionDAO().leerUbicaciones();
    }
}