package com.autobots.java.bankApp;

import java.time.LocalDateTime;

public class Transaction {
    private final String type; // тип операции (например, "Deposit", "Withdraw", "Transfer" и т.п.).
    private final double amount; //  сумма операции.
    private final LocalDateTime timeStamp = LocalDateTime.now(); //дата и время создания транзакции,
                                                                // инициализируется автоматически LocalDateTime.now().


    // Конструктор — задаёт тип и сумму.
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // Переопределён toString() для удобного вывода.
    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f", timeStamp, type, amount);
    }


}
