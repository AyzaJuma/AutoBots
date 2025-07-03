package com.autobots.java.lambda;

@FunctionalInterface // чтобы обозначит что функц.интерфейс
public interface MathOperation {
    // упростим калькулятор

    int operation (int a, int b);   // - абстрактный метод - нет реализации и оканчивается на ;


}
//универсальный метод
