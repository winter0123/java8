package com.example.java8to17;

/* [함수형 인터페이스]
 *
 * 추상 메소드를 딱 하나만 가지고 있는 인터페이스
 * SAM (Single Abstract Method) 인터페이스
 * @FunctionalInterface를 달아야함
 **/

@FunctionalInterface
public interface RunSomething {
    //추상 메소드
    //abstract void doIt에서 abstract가 생략된 형태
    //함수형 인터페이스에서 추상 메서드는 하나만 있어야함. 2개 있으면 안됨(위반시 컴파일 오류)
    void doIt();

    //static 메서드
    //public static void printName() 에서 public 생략 가능(java8에서 부터)
    static void printName(){
        System.out.println("RunSomething interface");
    }

    //default 메서드
    default void printAge() {
        System.out.println("100");
    }


}
