package com.example.java8to17.defaultMethod;

public interface Foo {
    void printName();

    //default 선언 시 인터페이스 내에서 구현 가능
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    //static 선언 시 인터페이스 내에서 구현 가능
    static void printAnyThing() {
        System.out.println("Foo");
    }

    String getName();
}