package com.subrata.poc.restclient;

public class PersonResponse {
    private String name;
    private String id;

    public PersonResponse(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public PersonResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonResponse{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
