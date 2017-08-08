package com.alma.prototypes;

import com.alma.prototypes.lifecycle.MongoClientManager;
import com.alma.prototypes.resources.CoffeeShopResource;
import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

public class CoffeShopApplication extends Application<CoffeShopConfiguration> {

    public static void main(final String[] args) throws Exception {
        new CoffeShopApplication().run(args);
    }

    @Override
    public String getName() {
        return "CoffeShop";
    }

    @Override
    public void initialize(final Bootstrap<CoffeShopConfiguration> bootstrap) {
        AssetsBundle bundle = new AssetsBundle("/html", "/");
        bootstrap.addBundle(bundle);
    }

    @Override
    public void run(final CoffeShopConfiguration configuration,
                    final Environment environment) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 32769);
            environment.jersey().register(new CoffeeShopResource(new Morphia().createDatastore(mongoClient, "CoffeDB")));
            MongoClientManager mongoClientManager = new MongoClientManager(mongoClient);
            environment.lifecycle().manage(mongoClientManager);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
