package com.fms.core.document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Dump {

    public static void main(String[] args) throws IOException {
        Person p = new Person("Ravi", 29);
        Person p1 = new Person("Hello", 12);
        Person p2 = new Person("Rithi", 17);
        Person p3 = new Person("Kumar", 18);
        Person p4 = new Person("Okala", 28);
        Person p5 = new Person("kokala", 28);

        List<Person> l = new ArrayList<>();
        l.add(p);
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);
        l.add(p5);

        Map<Integer, Optional<Person>> y = l.stream().filter(pr -> pr.getAge()>18).collect(Collectors.groupingBy(Person::getAge, Collectors.reducing(BinaryOperator.maxBy((o, t1) -> 1))));
        System.out.println(y);
        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
        //y.entrySet().stream().forEach(pf -> System.out.println(pf));
    }
}

class Person{
    private String name;

    Integer age;
    Person(String name, Integer age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}