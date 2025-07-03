package com.autobots.java.lambda.TaskLambda;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class Task_L_1 {
    public static void main(String[] args) {
        // ✅ Задача 1: Оставить только строки, начинающиеся на "A"

        List<String> names = List.of("Anna", "Bob", "Alex","Maria","Artur");

        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(result); // [Anna, Alex, Artur]

        // ✅ Задача 2: Преобразовать все строки в верхний регистр

        List<String> words = List.of("java", "lambda", "stream");

        List<String> res = words.stream()
                .map(String ::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(res); // [JAVA, LAMBDA, STREAM]

        //✅ Задача 3: Посчитать количество чётных чисел

        List<Integer> nums = List.of(1, 4, 5, 6, 8, 9);

        long count = nums.stream()
                .filter(num->num % 2 == 0)
                .count();

        System.out.println(count); // 3

        // ✅ Задача 4: Найти первую строку длиной больше 4 символов

        List<String> words1 = List.of("Sun", "Lambda", "Java", "Function");

        Optional<String> word = words1.stream()
                .filter(s-> s.length() > 4)
                .findFirst();

        System.out.println(word); // Optional[Lambda]

        // ✅ Задача 5: Отсортировать список по длине строк

        List<String> names2 = List.of("Tom", "Alexander", "Eva", "Maria");

        List<String> sortNames = names2.stream()
                .sorted((a,b)-> a.length() - b.length())
                .collect(Collectors.toList());

        System.out.println(sortNames); // [Tom, Eva, Maria, Alexander]
    }
}
