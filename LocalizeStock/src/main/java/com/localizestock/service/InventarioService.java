package com.localizestock.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.localizestock.dao.InventarioDAO;
import com.localizestock.model.Inventario;

@Path("/inventario")
public class InventarioService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Inventario> getInventario() {
        return new InventarioDAO().leerInventario();
    }
}