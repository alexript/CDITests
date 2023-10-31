/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package net.napilnik.ears.app.named;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author malyshev
 */
@Path("rest")
@RequestScoped
public class RestResource {

    @Context
    private UriInfo context;

    @Inject
    private BeanNamesProvider prov;

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }

    /**
     * Retrieves representation of an instance of
     * net.napilnik.ears.app.named.RestResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    // http://127.0.0.1:8080/app-named/resources/rest
    public String getJson() {
        return prov.getName();
    }

}
