package com.example.java8to17.defaultMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

//인터페이스 default 메소드, static 메소드
public class App {
    public static void main(String[] args) {

        //default 메소드
        Foo foo = new DefaultFoo("joy");
        foo.printName(); //joy
        foo.printNameUpperCase(); //JOY

        //static 메소드
        Foo.printAnyThing(); //Foo

        //----------------------------------------------------------------------------------
        //JAVA8 API 기본 메소드
        List<String> name = new ArrayList<>();
        name.add("joy");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        //--Iterable------------------------------------------------------------------------
        System.out.println("1.Iterable==========================");

        /*** forEach ***/
        //name.forEach(s -> {
        //    System.out.println(s);
        //});
        name.forEach(System.out::println); //메소드 레퍼런스 형태로 사용 가능
        System.out.println("-------");

        /*** spliterator : 반으로 데이터 쪼개기 ***/
        Iterable<String> iterable = name; //Iterable에서도 spliterator을 사용하지만 collection이 성능이 더 좋음
        Spliterator<String> ispliterator1 = iterable.spliterator();
        Spliterator<String> ispliterator2 = ispliterator1.trySplit();

        //--Collection------------------------------------------------------------------------
        System.out.println("2.Collection==========================");

        /*** stream ***/
        List<String> namesStartJ = name.stream()
                                            .map(String::toUpperCase)
                                            .filter(s -> s.startsWith("J"))
                                            .collect(Collectors.toList());
        System.out.println("Names start 'J': " + namesStartJ);

        /*** removeIf : 해당하는것 제거 ***/
        name.removeIf(s -> s.startsWith("j"));
        name.forEach(System.out::println); //whiteship toby foo

        /*** spliterator : 반으로 데이터 쪼개기 ***/
        Spliterator<String> spliterator1 = name.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        while (spliterator1.tryAdvance(System.out::println)); //toby foo
        System.out.println("-------");
        while (spliterator2.tryAdvance(System.out::println)); //joy whiteship
        System.out.println("3.Comparator==========================");

        //--Comparator------------------------------------------------------------------------
        /*** reversed : 역순정렬 ***/
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase; //Comparator는 Functional Interface임
        name.sort(compareToIgnoreCase.reversed()); //문자열을 대소문자 구분 없이 역순으로 정렬

        /*** thenComparing : 정렬 조건 여러개 ***/
        name.sort(compareToIgnoreCase.reversed().thenComparing(String::compareTo)); //역순정렬 -> 같은문자열 있을경우 알파벳 순서 정렬

        /*** reverseOrder : 역순으로 정렬 ***/
        name.sort(Comparator.reverseOrder());
        System.out.println("역순으로 정렬된: " + name); //[whiteship, toby, foo]

        /*** naturalOrder : 자연 순서로 정렬 ***/
        name.sort(Comparator.naturalOrder());
        System.out.println("자연 순서로 정렬된: " + name); //[foo, toby, whiteship]

        /*** nullsFirst : null을 가장 앞으로 정렬 ***/
        name.add(null);
        name.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("nullsFirst로 정렬된: " + name);

        /*** nullsLast : null을 가장 뒤로 정렬 ***/
        name.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("nullsLast로 정렬된: " + name);

        /*** comparing : 속성 값을 기준으로 정렬 ***/
        // Person 객체 생성
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 26));

        people.sort(Comparator.comparing(Person::getName)); // 이름으로 정렬
        System.out.println("이름으로 정렬된: " + people);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
