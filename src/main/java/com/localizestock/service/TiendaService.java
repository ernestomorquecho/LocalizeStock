package com.localizestock.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.localizestock.dao.TiendaDAO;
import com.localizestock.model.Tienda;

@Path("/tiendas")
public class TiendaService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tienda> getTiendas() {
        return new TiendaDAO().leerTiendas();
    }
}