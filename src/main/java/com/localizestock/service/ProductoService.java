package com.localizestock.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.localizestock.dao.ProductoDAO;
import com.localizestock.model.Producto;

@Path("/productos")
public class ProductoService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> obtenerTodos() {
        ProductoDAO dao = new ProductoDAO();
        return dao.leerProductos();
    }
}