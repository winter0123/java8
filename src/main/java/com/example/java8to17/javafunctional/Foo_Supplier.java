package com.example.java8to17.javafunctional;

import java.util.function.Supplier;

//Supplier<T> : T 타입의 값을 제공하는 함수 인터페이스
//함수 사용 할 때, 받아올 값의 type을 정의하면 됨
public class Foo_Supplier {
    public static void main(String[] args) {

        //람다식에 넘기는 인자가 없음
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10); //10

    }
}
