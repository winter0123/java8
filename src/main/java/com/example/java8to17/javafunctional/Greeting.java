package com.example.java8to17.javafunctional;

public class Greeting {
    private String name;

    public Greeting() {
    }

    public Greeting(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "h1 " + name;
    }
}
