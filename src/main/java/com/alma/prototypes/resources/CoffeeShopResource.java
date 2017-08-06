package com.alma.prototypes.resources;

import com.alma.prototypes.db.model.Order;
import com.codahale.metrics.annotation.Timed;
import org.mongodb.morphia.Datastore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/coffeeshop")
@Produces(MediaType.APPLICATION_JSON)
public class CoffeeShopResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeShopResource.class);

    private Datastore datastore;

    public CoffeeShopResource(Datastore datastore) {
        this.datastore = datastore;
    }

    @POST
    @Path("/order")
    @Timed
    public Response saveOrder(Order order) {
        datastore.save(order);
        return Response.created(URI.create(order.getId())).entity(order).build();
    }
}

