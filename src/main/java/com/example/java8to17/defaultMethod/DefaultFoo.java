package com.example.java8to17.defaultMethod;

public class DefaultFoo implements Foo { // implements Foo, Bar 동시 상속 시 같은 default 메소드로 인하여 오류 발생

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName(){
        System.out.println(this.name);
    }

    @Override
    public String getName(){
        return this.name;
    }
}
