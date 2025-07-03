package com.autobots.java.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiLesson {
    public static void main(String[] args) {
        //Задача №1. Нужно из коллекции вытащить имена которые начинаются на букву А вверхнем регистре и по
        // алфавиту:

        List<String> names = List.of("Anna", "Bob", "Alex");

        List<String> nameWithA = new ArrayList<>();

        for (String name : names) {
            if (name.startsWith("A")) {
                nameWithA.add(name.toUpperCase());
                Collections.sort(nameWithA);
            }
        }
        System.out.println(nameWithA); // [ALEX, ANNA]

        // Решим через функциональный интерфейс

        List<String> res = names.stream()
                .filter(name -> name.startsWith("A")) // фильтрация по условию
                .map(String::toUpperCase)            // преобразовали
                .sorted()                            // отсортировали по алфавиту
                .collect(Collectors.toList());       // сбор результатов в коллекцию, без этого метода выйдет ошибка
        System.out.println(res);                    // [ALEX, ANNA]


        // Задача №2. нужно найти общую сумму чисел в массиве

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int res1 = 0;
        for (int num : numbers) {
            res1 += num;
        }
        System.out.println(res1); // 21

        // решим через стримАпи

        int totalSum = numbers.stream()         // обращаемся к коллекции намберс и вызываем метод стрим
                // под копотом открывает поток и берет доступ к этим значениям намберс, начинает перебирать
                .mapToInt(num -> num)           // преобразует большой инт в маленький, т.к.
                // totalSum мал.инт, коллекции работают только с большими типами данных
                .sum();                         // метод суммирует
        System.out.println(totalSum); // 21


        // Задача №3. нужно найти количество элементов в коллекции

        int totalElements = (int) numbers.stream() // скастили в маленький инт
                .count();                         // метод для подсчета количества элементов
        System.out.println(totalElements); // 6

        // Задача №4. нужно найти минимальное число в коллекции:

        numbers.stream()                  // открываем поток
                .min(Integer::compareTo) // найти мин число, нужно указать явный тип, который указан в коллекци
                // и вызываем готовый метод compareTo, который начинает сравнивать все элементы между собой
                .ifPresent(System.out::println); // 1 //метод ifPresent если есть результат, то на печать

        // Оператор :: в Java называется method reference - это сокращенная форма записи лямбда-выражений,
        // когда ты просто передаешь существующий метод как функцию.

        // Задача №5. Есть список состоящий из строк, нужно вывести те элементы, длина которых больше 3 и только
        // тот элемент, который встретился первым - "three":

        List<String> list = List.of("one", "two", "three", "Hello", "four", "five");

        list.stream()
                .filter(s -> s.length() > 3) // используем метод filter, чтобы по размеру отфильтровать
                .findFirst() // метод найди первый
                .ifPresent(System.out::println); // three // если есть, то выведи на консоль

        // создадим список сотрудников в классе StreamApiLesson для классса Employee
        List<Employee> employees = List.of(
                new Employee(1, "Alice", 28, 3000, "IT"),
                new Employee(2, "Bob", 35, 4000, "HR"),
                new Employee(3, "Charlie", 40, 5000, "Finance"),
                new Employee(4, "David", 25, 3500, "IT"),
                new Employee(5, "Eva", 30, 4200, "Marketing"),
                new Employee(6, "Frank", 45, 6000, "Finance"),
                new Employee(7, "Grace", 32, 4100, "HR"),
                new Employee(8, "Henry", 29, 3900, "IT"),
                new Employee(9, "Isabel", 38, 4500, "Marketing"),
                new Employee(10, "Jack", 27, 3600, "IT")
        );
        // необходимо создать список, который состоит из айтишников

        List<Employee> itEmployees = employees.stream()
                        .filter(s-> s.getDepartment().equalsIgnoreCase("it"))
                        .collect(Collectors.toList());
        System.out.println(itEmployees); // [Employee{id=1, name='Alice', age=28, salary=3000, department='IT'},
                                          // Employee{id=4, name='David', age=25, salary=3500, department='IT'},
                                          // Employee{id=8, name='Henry', age=29, salary=3900, department='IT'},
                                          // Employee{id=10, name='Jack', age=27, salary=3600, department='IT'}]

        // если решить без стрим:

        List<Employee> itEmployees2 = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getDepartment().equalsIgnoreCase("it")){
                itEmployees2.add(employee);
            }
        }
        System.out.println(itEmployees2);


        // необходимо сгруппировать по отделам:

        Map<String, List<Employee>> employeeByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // для вывода в удобном виде:
        employeeByDepartment.forEach((department, list1)-> {
            list1.forEach(System.out::println);
        });
        // на консоли получаем:

        //Employee{id=3, name='Charlie', age=40, salary=5000, department='Finance'}
        //Employee{id=6, name='Frank', age=45, salary=6000, department='Finance'}
        //Employee{id=2, name='Bob', age=35, salary=4000, department='HR'}
        //Employee{id=7, name='Grace', age=32, salary=4100, department='HR'}
        //Employee{id=1, name='Alice', age=28, salary=3000, department='IT'}
        //Employee{id=4, name='David', age=25, salary=3500, department='IT'}
        //Employee{id=8, name='Henry', age=29, salary=3900, department='IT'}
        //Employee{id=10, name='Jack', age=27, salary=3600, department='IT'}
        //Employee{id=5, name='Eva', age=30, salary=4200, department='Marketing'}
        //Employee{id=9, name='Isabel', age=38, salary=4500, department='Marketing'}

        System.out.println("********************************");
        // решим эту задачи без стримапи:

        Map<String, List<Employee>> employeeByDepartment2 = new HashMap<>();

        for (Employee employee : employees) {
            employeeByDepartment2.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            employeeByDepartment2.get(employee.getDepartment()).add(employee);
        }
        for (Map.Entry<String, List<Employee>> entry : employeeByDepartment2.entrySet()){
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }
    }
}
