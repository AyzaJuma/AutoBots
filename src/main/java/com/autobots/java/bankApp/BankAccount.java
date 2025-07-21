package com.autobots.bankApp;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

public abstract class BankAccount {  // абстрактный базовый класс для банковского счёта.
    protected String accountNumber;// уникальный номер счёта, генерируется через UUID.randomUUID()
    protected double balance;  //  текущий баланс счёта
    protected final Client owner; // владелец счёта типа Client.
    protected final Currency currency; // валюта счёта (класс Currency).
    protected final List<Transaction> transactions = new ArrayList<>(); // список операций по счёту (класс Transaction).

    // Конструктор:
    //Принимает владельца owner и валюту currency.
    //Генерирует уникальный номер счёта.

    public BankAccount(Client owner, Currency currency) {
        this.owner = owner;
        this.currency = currency;
        this.accountNumber = UUID.randomUUID().toString();
    }

    // Абстрактные методы заставляют наследников реализовать конкретную логику пополнения и снятия — удобно,
    // чтобы в зависимости от типа счёта были разные правила

    // Абстрактный метод пополнение счёта:
    public abstract void deposit(double amount);

    // Абстрактный метод снятие со счёта (возвращает true, если успешно):
    public abstract boolean withdraw(double amount);

    // метод добавляет транзакцию в список:
    public void addTransaction(String type, double amount){
        transactions.add(new Transaction(type,amount));

    // Геттеры и сеттеры для основных полей:
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return owner;
    }

    public Currency getCurrency() {
        return currency;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", owner=" + owner +
                ", currency=" + currency +
                ", transactions=" + transactions +
                '}';
    }
}
