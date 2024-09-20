package com.example.java8to17.streamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Stream Api 개념
public class App1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("joy");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        //stream을 썼다고 무조건 names 자체가 바뀌지는 않음
        Stream<String> stringStream = names.stream().map(String::toUpperCase);
        names.forEach(System.out::println);  //joy whiteship toby foo
        System.out.println("1.=====================");


        /***중개 오퍼레이션(Stream을 return 한다) ***/
        //터미널 오퍼레이션이 오기 전까지는 실행안됨
        names.stream().map((s) -> {
            System.out.println(s); //출력안됨
            return s.toUpperCase();
        });
        names.forEach(System.out::println); //joy whiteship toby foo
        System.out.println("2.=====================");


        /*** 터미널 오퍼레이션(Stream을 return하지 않는다) ***/
        List<String> collect1 = names.stream().map((s) -> {
            System.out.println(s); //joy whiteship toby foo
            return s.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println("3.=====================");

        collect1.forEach(System.out::println); //JOY WHITESHIP TOBY FOO


        /*** 병렬처리 : parallelStream() ***/
        //데이터가 엄청 클때만 유효함
        List<String> collect2 = names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collect2.forEach(System.out::println);
    }
}
