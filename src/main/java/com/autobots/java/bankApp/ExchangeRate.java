package com.autobots.java.bankApp;

import java.util.Map;

public class ExchangeRate {

    // лучше вынеси как static final поле класса, чтобы не создавать новую Map при каждом вызове:
    private static final Map<Currency, Double> toUSD = Map.of(  // Имеет словарь toUSD — курс валют к доллару (USD).
            Currency.USD, 1.0,
            Currency.EUR, 1.1,
            Currency.KGS, 0.011
    );

    public static double convert(double amount, Currency from, Currency to) {  // конвертации валют
        if (from == to) return amount;  // Если исходная и целевая валюта совпадают, возвращает исходную сумму.


        // Конвертирует сумму из исходной валюты в доллары, а затем из долларов в целевую валюту:

        double usd = amount * toUSD.get(from);
        return usd / toUSD.get(to);

    }


}
