package com.example.java8to17.javafunctional;

import java.util.function.BinaryOperator;

// BinaryOperator<T> : BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는 함수 인터페이스
// 입력 type과 반환 type이 같음
public class Foo_BinaryOperator {
    public static void main(String[] args) {

        // 두 정수를 더하기
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(5, 3)); // 8

        // 두 문자열 결합
        BinaryOperator<String> concatenate = (str1, str2) -> str1 + str2;
        System.out.println(concatenate.apply("Hello, ", "World!")); // "Hello, World!"
    }
}
