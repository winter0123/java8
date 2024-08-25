package com.example.java8to17.javafunctional;

import java.util.function.Function;

public class Plus10Functional implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
