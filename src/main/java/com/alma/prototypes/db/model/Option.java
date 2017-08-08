package com.alma.prototypes.db.model;

import org.mongodb.morphia.annotations.Id;

public class Option {
    @Id
    private String id;
    private String name;
    private String appliesTo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppliesTo() {
        return appliesTo;
    }

    public void setAppliesTo(String appliesTo) {
        this.appliesTo = appliesTo;
    }
}
