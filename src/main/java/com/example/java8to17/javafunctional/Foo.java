package com.example.java8to17.javafunctional;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();
    }

    private void run(){
        final int baseNumber = 10; //값 변경이 없으면 final이 생략된 effective final
        //baseNumber++; 값을 변경하면 effective final이 아님. 람다에서 참조 못함

        //로컬 class: 메소드 내부에 있는 class
        class LocalClass {
            int baseNumber = 11;
            void printBaseNumber(){
                System.out.println(baseNumber); //11
            }
        }

        // 익명 class
        // 1. 인터페이스 구현(Runnable,MouseListener)
        // 2. 추상클래스 확장(Thread)
        // 3. java8 함수형인터페이스(Function, Consumer) 등등
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); //parameter로 받아오는 값 출력됨
            }
        };

        // 람다 = 익명함수
        // 쉐도잉 이슈가 없음
        // 람다와 람다를 감싸는 method는 같은 스코프임. baseNumber을 재정의 할 수 없음
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }
}
