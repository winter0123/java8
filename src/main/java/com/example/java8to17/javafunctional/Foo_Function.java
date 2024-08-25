package com.example.java8to17.javafunctional;

import java.util.function.Function;

// Function<T, R> : T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스(apply)
// A.compose(B): 함수 조합용 메소드
// A.andThen(B): 함수 조합용 메소드
// 입력 type과 반환 type이 다를 수 있음
public class Foo_Function {
    public static void main(String[] args) {
/* Function<T, R> : T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스(apply) */

        //java8에서 제공하는 함수형 인터페이스를 class로 만들어 사용한 형태
        Plus10Functional Plus10Functional = new Plus10Functional();
        System.out.println(Plus10Functional.apply(1)); //11

        //함수형 인터페이스를 직접 사용한 형태
        Function<Integer, Integer> plus11 = (i) -> {
            return i + 11;
        };
        System.out.println(plus11.apply(1)); //12

        //코드를 한줄로 줄여서 사용가능
        Function<Integer, Integer> plus12 = (i) -> i + 12;
        System.out.println(plus12.apply(1)); //13

        //입력과 출력이 다른 형태
        Function<String, Integer> stringLengthFunction = (str) -> str.length();
        System.out.println(stringLengthFunction.apply("Hello")); // 5


/* A.compose(B) : 함수 조합용 메소드  */
// B가 먼저 실행되고, B의 결과 갑을  A가 뒤에 실행됨
        Function<Integer, Integer> multiply2 = (i) -> i * 2; //곱하기

        Function<Integer, Integer> multiply2AndPlus10 = Plus10Functional.compose(multiply2); // 함수형으로 선언 후 사용
        System.out.println(multiply2AndPlus10.apply(2)); // (2 * 2) + 10 = 14

        System.out.println(Plus10Functional.compose(multiply2).apply(2)); // 함수형으로 선언 없이 사용

/* A.andThen(B) : 함수 조합용 메소드  */
// A가 먼저 실행되고, A의 결과 값을 B에서 사용
        System.out.println(Plus10Functional.andThen(multiply2).apply(2)); // (10 + 2) * 2 = 24
    }

}
