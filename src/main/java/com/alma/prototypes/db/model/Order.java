package com.alma.prototypes.db.model;

import org.mongodb.morphia.annotations.Id;

public class Order {

    @Id
    private String id;

    /*
    {
        "type":
            {
            "name":"Green Tea",
             "family":"Tea"
            },
        "size":"Large",
        "owner":"Albert",
        "coffeeShopId":1
    }
    */
    private String    size;
    private String    owner;
    private String[]  selectedOptions;
    private long      coffeeShopId;
    private DrinkType type;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String[] getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(String[] selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public long getCoffeeShopId() {
        return coffeeShopId;
    }

    public void setCoffeeShopId(long coffeeShopId) {
        this.coffeeShopId = coffeeShopId;
    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType drinkType) {
        this.type = drinkType;
    }

    public String getId() {
        return id;
    }
}
