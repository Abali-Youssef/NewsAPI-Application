package com.ex.appapi.models;

import java.io.Serializable;

public class Source implements Serializable {
    private String Id;
    private String name;

    public Source(String id, String name) {
        Id = id;
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
