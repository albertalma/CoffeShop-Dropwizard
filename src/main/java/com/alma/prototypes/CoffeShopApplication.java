package com.alma.prototypes;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.alma.prototypes.lifecycle.MongoClientManager;
import com.alma.prototypes.resources.CoffeeShopResource;
import com.alma.prototypes.resources.ExtraOptionsResource;
import com.mongodb.MongoClient;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
    public void run(final CoffeShopConfiguration configuration, final Environment environment) {
        MongoClient mongoClient = new MongoClient("localhost", 32769);
        Datastore datastore = new Morphia().createDatastore(mongoClient, "CoffeDB");
        environment.jersey().register(new CoffeeShopResource(datastore));
        environment.jersey().register(new ExtraOptionsResource(datastore));
        MongoClientManager mongoClientManager = new MongoClientManager(mongoClient);
        environment.lifecycle().manage(mongoClientManager);
    }

}
