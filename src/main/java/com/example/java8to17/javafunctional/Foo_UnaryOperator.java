package com.example.java8to17.javafunctional;

import java.util.function.UnaryOperator;

// UnaryOperator<T> : Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스(apply)
// Function에서 사용하는 조합용 합수를 모두 사용 가능(compose, andThen)
// 입력 type과 반환 type이 같음
public class Foo_UnaryOperator {
    public static void main(String[] args) {

        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        UnaryOperator<Integer> multiply2 = (i) -> i * 2;

        System.out.println(plus10.apply(10)); //20
        System.out.println(plus10.compose(multiply2).apply(1)); // (1 * 2) + 10 = 12
        System.out.println(plus10.andThen(multiply2).apply(1)); // (1 + 10) * 2 = 22

    }
}
