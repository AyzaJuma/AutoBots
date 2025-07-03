package com.autobots.java.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLesson {
    //в этом классе саоздадим майн и вызовем наш функц.метод
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;
        MathOperation multi = (a,b) -> a * b;

        System.out.println("5 + 3 = " + addition.operation(5,3)); // 5 + 3 = 8
        System.out.println("5 * 3 = " + addition.operation(5,3)); // 5 * 3 = 8

        //Виды функциональных интерфейсов:

        // 1. Predicate:
        Predicate<String> isNotEmpty = s -> !s.isEmpty(); // принимает Объект и возвращает boolean

        System.out.println(isNotEmpty.test("")); // false
        System.out.println(isNotEmpty.test("Java")); // true - не пустая строка

        // 2. Function
        Function<Integer, String> toString = i -> "Число: " + i; // принимает инт, возвращает стринг
        System.out.println(toString.apply(10)); //Число: 10

        // 3.Consumer
        Consumer<String> print = s-> System.out.println("Writing: " + s);
        print.accept("Hello"); // Writing: Hello
    }
}
