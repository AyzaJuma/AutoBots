package com.autobots.java.bankApp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private final String fullName; // полное имя клиента (например, "Иван Иванов")
    private final String clientID; //  уникальный идентификатор клиента, который генерируется автоматически (UUID)
    private final String pin; // пин-код клиента (для аутентификации)
    private final List<BankAccount> accounts = new ArrayList<>(); // список банковских счетов клиента

//    Конструктор:
//    При создании объекта клиента принимает fullName и pin
//    Генерирует clientID с помощью UUID.randomUUID()

    public Client(String fullName, String pin) {

        this.fullName = fullName;
        this.pin = pin;
        this.clientID = String.valueOf(UUID.randomUUID());
    }

    // создадим метод проверяет совпадение пин-кода

    public boolean authenticate(String inputPin){
        return this.pin.equals(inputPin); // если правильно ввел пин
    }

    // метод добавляет банковский счет в список

    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    public String getFullName() {
        return fullName;
    }

    public String getClientID() {
        return clientID;
    }

    public String getPin() {
        return pin;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    // Сеттера нет — правильно, ведь поля final.


    @Override
    public String toString() {
        return "Client{" +
                "fullName='" + fullName + '\'' +
                ", clientID='" + clientID + '\'' +
                ", pin='" + pin + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
