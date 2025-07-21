package com.autobots.java.bankApp;



public class DepositAccount extends BankAccount{ // Наследуется от BankAccount.

    public DepositAccount(Client owner, Currency currency) {
        super(owner, currency);
    }
    // метод увеличивает баланс на сумму и добавляет транзакцию с типом "Deposit".
    @Override
    public void deposit(double amount) {
        balance +=amount;
        addTransaction("Deposit", amount);
    }

    // метод проверяет, хватает ли баланса, если да — уменьшает баланс,
    // добавляет транзакцию "Withdraw" и возвращает true, иначе — false.
    @Override
    public boolean withdraw(double amount) { // cнимает деньги с баланса
        if (amount <= balance){
            balance -= amount;
            addTransaction("Withdraw", amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", owner=" + owner +
                ", currency=" + currency +
                ", transactions=" + transactions +
                '}';
    }
}
