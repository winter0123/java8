package com.example.java8to17.javafunctional;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

//메소드 레퍼런스 : 람다를 메소드 레퍼런스 형태로 사용하기
public class App {
    public static void main(String[] args) {

        //static 메소드 참조
        //타입::스태틱 메소드
        //UnaryOperator<String> hi = (s) -> "hi " + s;  //람다
        UnaryOperator<String> hi = Greeting::hi;        //메소드 레퍼런스
        hi.apply("joy");

        //특정 객체의 인스턴스 메소드 참조
        //객체 레퍼런스::인스턴스 메소드
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("joy"));

        //생성자 참조 : public Greeting()
        //타입::new
        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();

        //생성자 참조 : public Greeting(String name)
        //타입::new
        Function<String, Greeting> joyGreeting = Greeting::new;
        Greeting joy = joyGreeting.apply("joy");
        System.out.println(joy.getName());

        //임의 객체의 인스턴스 메소드 참조
        //타입::인스턴스 메소드
        String[] names = {"joy", "bongbong", "happy"};
        //Arrays.sort(names, (o1,o2) -> 0);              //람다
        Arrays.sort(names, String::compareToIgnoreCase); //메소드 레퍼런스
        System.out.println(Arrays.toString(names));
    }
}
