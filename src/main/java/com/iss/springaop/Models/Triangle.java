package com.iss.springaop.Models;

public class Triangle {
    private String name;

    public String getName() {
        System.out.println("returning name");
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }
}
