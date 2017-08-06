package com.alma.prototypes.resources;

import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/coffeshop")
@Produces(MediaType.APPLICATION_JSON)
public class CoffeShopResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeShopResource.class);

    public CoffeShopResource() {
    }

    @GET
    @Timed
    public String coffeShop(@QueryParam("name") Optional<String> name) {
        return "Testing";
    }
}

