package com.localizestock.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Path("/pagos")
public class PagoService {

    private static final String STRIPE_API_KEY = "sk_test_51Sc66HHRnhuEsxXmdp4cij7411msW5D7Q1hdo10Tpglrxqm2FsEiPffWS1pjYySU7CdK0PAZ7smSkag5sX9Z131W00LdMNqB0I";

    static {
        Stripe.apiKey = STRIPE_API_KEY;
    }

    @POST
    @Path("/crear-intento")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearIntentoPago(@QueryParam("monto") Double monto, @QueryParam("moneda") String moneda) {
        try {
            long cantidad = (long) (monto * 100);

            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(cantidad)
                    .setCurrency(moneda != null ? moneda : "mxn")
                    .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build()
                    )
                    .build();

            PaymentIntent paymentIntent = PaymentIntent.create(params);

            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("clientSecret", paymentIntent.getClientSecret());
            
            return Response.ok(respuesta).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Error procesando pago: " + e.getMessage()).build();
        }
    }
}