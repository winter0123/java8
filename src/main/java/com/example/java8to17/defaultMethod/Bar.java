package com.example.java8to17.defaultMethod;

public interface Bar {

    //Bar와 Foo 두곳 모두 같은 이름의 default 메소드가 존재할 시 다중상속 불가능
    //다중 상속 한다면 상속받은 클래스에서 재정의 하여 사용하여야 함
    default void printNameUpperCase(){
        System.out.println("Bar");
    }
}
