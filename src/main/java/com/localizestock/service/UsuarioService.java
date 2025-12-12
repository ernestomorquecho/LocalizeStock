package com.localizestock.service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.localizestock.dao.UsuarioDAO;
import com.localizestock.model.Usuario;

@Path("/usuarios")
public class UsuarioService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> obtenerUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.leerUsuarios();
    }

    // --- NUEVO ENDPOINT PARA REGISTRAR ---
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        boolean exito = dao.guardarUsuario(usuario);

        if (exito) {
            return Response.status(201).entity(usuario).build();
        } else {
            return Response.status(500).entity("Error al guardar usuario").build();
        }
    }
}