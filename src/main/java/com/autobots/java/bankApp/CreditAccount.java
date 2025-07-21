package com.autobots.java.bankApp;

public class CreditAccount extends BankAccount{ // Наследует BankAccount.

    // Имеет кредитный лимит- это максимальная сумма, которую можно снять сверх текущего баланса.
    private static final double creditLimit = 1000;

    public CreditAccount(Client owner, Currency currency) {
        super(owner, currency);
    }

    //метод При депозите просто увеличивает баланс. Добавляет транзакции на операции.
    @Override
    public void deposit(double amount) {
        balance +=amount;
        addTransaction("Deposit", amount);
    }

    //метод При снятии денег (withdraw) проверяет, хватает ли средств с учётом лимита. Добавляет транзакции на операции.
    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance + creditLimit){
            balance -= amount;
            addTransaction("Withdraw", amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", owner=" + owner +
                ", currency=" + currency +
                ", transactions=" + transactions +
                '}';
    }
}
