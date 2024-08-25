package com.example.java8to17.javafunctional;

import java.util.function.BiFunction;

//BiFunction<T, U, R>: T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
//입력 type과 반환 type이 다를 수 있음
public class Foo_BiFunction {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> plus_plus10 = (i, j) -> i + j + 10;
        System.out.println(plus_plus10.apply(1,1)); //12
    }
}
