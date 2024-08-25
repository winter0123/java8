package com.example.java8to17;

// 함수형 인터페이스 사용 방법
// java8 람다형으로 바꾸는 법
// 익명 내부 클래스(anonymous inner class)
public class Foo {
    public static void main(String[] args) {

/*
        //return 값이 없을때
        //과거 사용 방법
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };
*/
        //Java 8 : 람다 표현식
        RunSomething runSomething = () -> System.out.println("Hello");
        runSomething.doIt();


/*
        //return 존재 할 때
        //과거 사용 방법
        RunSomething2 runSomething2 = new RunSomething2() {
            @Override
            public int doIt(int number) {
                return number + 10;
            }
        };
*/
        //Java 8 : 람다 표현식
        RunSomething2 runSomething2 = number -> number + 10;

        //1을 넣으면 계속 11이 나와야함
        System.out.println(runSomething2.doIt(1));
        System.out.println(runSomething2.doIt(1));
        System.out.println(runSomething2.doIt(1));
        //2를 넣으면 계속 12가 나와야 함
        System.out.println(runSomething2.doIt(2));
        System.out.println(runSomething2.doIt(2));
        System.out.println(runSomething2.doIt(2));

/*
        동일한 결과값을 보장 못하면 함수형 프로그래밍이 아님
        함수 밖에 변수(baseNumber)를 참조할 경우 동일한 결과값이 보장안됨(문법가능)
        순수한 함수라 보기 힘들고 baseNumber 상태 값을 가지고 상태 값에 의존함

        baseNumber 값을 RunSomething2 밖에 선언(final 변수로 가정됨)
        doIt 내부에서 변경불가능(문법오류)
        doIt 밖에서 변경 불가능(문법오류)
*/

//        int baseNumber = 10;
//        RunSomething2 runSomething2 = new RunSomething2() {
//            @Override
//            public int doIt(int number) {
//                return number + baseNumber;
//            }
//        };


/*
        baseNumber 값을 RunSomething2 안에 선언
        doIt 내부 변경 가능(문법가능: 동일한 결과값은 보장x)
*/

//        RunSomething2 runSomething2 = new RunSomething2() {
//            int baseNumber = 10;
//            @Override
//            public int doIt(int number) {
//                return number + baseNumber;
//            }
//        };
    }
}
