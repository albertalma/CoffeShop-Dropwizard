package com.alma.prototypes;

import com.alma.prototypes.resources.CoffeShopResource;
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
        AssetsBundle bundle = new AssetsBundle("/assets", "/");
        bootstrap.addBundle(bundle);
    }

    @Override
    public void run(final CoffeShopConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new CoffeShopResource());
    }

}
