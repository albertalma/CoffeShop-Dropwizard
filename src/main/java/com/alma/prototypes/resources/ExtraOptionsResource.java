package com.alma.prototypes.resources;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mongodb.morphia.Datastore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alma.prototypes.db.model.Option;
import com.codahale.metrics.annotation.Timed;

@Path("/extras")
@Produces(MediaType.APPLICATION_JSON)
public class ExtraOptionsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeShopResource.class);

    private Datastore           datastore;

    public ExtraOptionsResource(Datastore datastore) {
        this.datastore = datastore;
    }

    @GET
    @Timed
    public Response getExtraOptions() {
        List<Option> availableOptions = StreamSupport.stream(datastore.find(Option.class).spliterator(), false).collect(
                Collectors.toList());
        return Response.ok(availableOptions).build();
    }
}
