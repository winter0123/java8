package com.example.java8to17.defaultMethod;

//인터페이스 default 메소드, static 메소드
public class App {
    public static void main(String[] args) {

        //default 메소드
        Foo foo = new DefaultFoo("joy");
        foo.printName(); //joy
        foo.printNameUpperCase(); //JOY

        //static 메소드
        Foo.printAnyThing(); //Foo
    }
}
