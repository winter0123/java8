package com.example.java8to17.javafunctional;

import java.util.function.Predicate;

// Predicate<T> : T 타입을 받아서 boolean을 리턴하는 함수 인터페이스(test)
// A.and(B) : 함수 조합용 메소드
// A.or(B) : 함수 조합용 메소드
// A.negate() : 함수 조합용 메소드( 논리적 NOT 연산 )
public class Foo_Predicate {
    public static void main(String[] args) {

/*  Predicate<T> : T 타입을 받아서 boolean을 리턴하는 함수 인터페이스(test)*/
        Predicate<String> startWithJoy = (s) -> s.startsWith("joy");
        System.out.println(startWithJoy.test("joy"));       //true
        System.out.println(startWithJoy.test("Not joy"));   //false

        Predicate<Integer> isEven = (i) -> i%2 == 0; //Even 짝수, Odd 홀수
        Predicate<Integer> isGreaterThan10 = (number) -> number > 10; //10보다 큰지 확인
        System.out.println(isEven.test(10));          //true
        System.out.println(isGreaterThan10.test(10)); //false


/* A.and(B) : 함수 조합용 메소드 */
        //함수형 선언 후 사용
        Predicate<Integer> isEvenAndOdd = isEven.and(isGreaterThan10);
        System.out.println(isEvenAndOdd.test(10));  //false

        //함수형 선언 없이 바로 사용
        System.out.println(isEven.and(isGreaterThan10).test(10)); //false

/* A.or(B) : 함수 조합용 메소드 */
        //함수형 선언 후 사용
        Predicate<Integer> isEvenOrOdd = isEven.or(isGreaterThan10);
        System.out.println(isEvenOrOdd.test(10));  //true

        System.out.println(isEven.or(isGreaterThan10).test(10)); //true

/* A.negate(B) : 함수 조합용 메소드 */
        //함수형 선언 후 사용
        Predicate<Integer> isOdd = isEven.negate(); //negate 부정하다
        System.out.println(isOdd.test(7)); // true (7는 홀수)

        //함수형 선언 없이 바로 사용
        System.out.println(isEven.negate().test(7)); // true
    }
}
