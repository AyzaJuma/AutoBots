package com.autobots.java.lambda.TaskLambda;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Task_L_2 {
    public static void main(String[] args) {
        // Задача 1. Отфильтровать слова, которые содержат букву «e» (регистр не важен)

        List<String> words = List.of("Apple", "banana", "Pear", "Cherry", "melon");

        List<String> wordsE = words.stream()
                .filter(w-> w.toLowerCase().contains("e"))
                .collect(Collectors.toList());

        System.out.println(wordsE); // [Apple, Pear, Cherry, melon]

        // Задача 2. Преобразовать список чисел в список строк с префиксом "Num: "

        List<Integer> numbers = List.of(5, 10, 15);

        List<String> numbersNum = numbers.stream()
                .map(n -> "Num: " + n)
                .collect(Collectors.toList());

        System.out.println(numbersNum); // [Num: 5, Num: 10, Num: 15]

       //  Задача 3. Найти максимальное число из списка

        List<Integer> nums = List.of(7, 3, 9, 2, 10);

        Optional<Integer> max = nums.stream()
                .max(Integer::compareTo);

        System.out.println(max.orElse(null)); // 10

        // второй способ, если уверен, что список не пуст

        int max2 = nums.stream()
                .mapToInt(n->n) // Преобразуем каждый Integer в int (примитив).
                       // mapToInt превращает Stream<Integer> в IntStream.
                       // n -> n простая лямбда, возвращающая то же число.
                .max() // метод мах
                .orElseThrow(); // Если вдруг список пустой — выбрасывает исключение.

        System.out.println(max2); // 10

        // Задача 4. Проверить, что все строки не пустые
        //allMatch(...) — терминальная операция Stream API.
        //Она проверяет, все ли элементы соответствуют условию.

        List<String> strings = List.of("a", "b", "c", "");

       boolean allNotEmpty = strings.stream()
                .allMatch(s-> !s.isEmpty());

        System.out.println(allNotEmpty); // false

        // Задача 5. Перевернуть строки в списке
        List<String> words3 = List.of("java", "stream", "code");

        List<String> revers = words3.stream()
                .map(s-> new StringBuilder(s).reverse().toString())
                .collect(Collectors.toList());
        System.out.println(revers); // [avaj, maerts, edoc]


        // Задача 6. перевернуть только строки длиннее 4 символов, а остальные оставить как есть

        List<String> words4 = List.of("java", "stream", "code");

        List<String> transformed = words4.stream()
                .map(s-> s.length() > 4
        ? new StringBuilder(s).reverse().toString()
                : s)
                .collect(Collectors.toList());
        System.out.println(transformed); //

    }
}
