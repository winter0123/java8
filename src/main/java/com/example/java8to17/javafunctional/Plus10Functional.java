package com.example.java8to17.javafunctional;

import java.util.function.Function;

//java8에서 제공하는 함수형 인터페이스를 class로 만들어 사용한 형태
public class Plus10Functional implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
