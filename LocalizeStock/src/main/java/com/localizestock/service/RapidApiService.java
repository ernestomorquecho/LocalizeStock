package com.localizestock.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/busqueda-externa")
public class RapidApiService {

    private static final String API_URL = "https://real-time-product-search.p.rapidapi.com/search";
    private static final String API_KEY = "6227206aa0msh6d052bd76f07785p14a44ajsna2fd13c1ce96";
    private static final String API_HOST = "real-time-product-search.p.rapidapi.com";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarEnWalmart(@QueryParam("q") String query) {
        if (query == null || query.isEmpty()) {
            return Response.status(400).entity("Falta el término de búsqueda 'q'").build();
        }

        try {
            String urlCompleta = API_URL + "?q=" + query.replace(" ", "%20") + "&country=mx";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlCompleta))
                    .header("X-RapidAPI-Key", API_KEY)
                    .header("X-RapidAPI-Host", API_HOST)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return Response.ok(response.body()).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Error conectando a API externa").build();
        }
    }
}