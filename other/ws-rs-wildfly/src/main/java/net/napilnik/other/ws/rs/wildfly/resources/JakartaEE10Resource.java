package net.napilnik.other.ws.rs.wildfly.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("jakartaee10")
public class JakartaEE10Resource {

    @GET
    // http://127.0.0.1:8080/ws-rs-wildfly-1.0-SNAPSHOT/resources/jakartaee10
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
