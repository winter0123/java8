package com.example.java8to17.javafunctional;

import java.util.function.Consumer;

//Consumer<T> : T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스(accept)
//andThen : 함수 조합용 메소드
public class Foo_Consumer {
    public static void main(String[] args) {

        Consumer<Integer> printT1 = (i) -> System.out.println(i);
        Consumer<Integer> printT2 = (i) -> System.out.println(i);

        printT1.accept(10); //10
        printT2.accept(20); //20

        printT1.andThen(printT2).accept(10);
        //10
        //10
    }
}
