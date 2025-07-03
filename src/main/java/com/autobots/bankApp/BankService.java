package com.autobots.bankApp;

public class BankService {
    // Метод transfer:
    //Пытается снять (withdraw) с аккаунта from указанную сумму amount.
    //Если успешно, конвертирует эту сумму из валюты from в валюту to через ExchangeRate.convert.
    //Затем кладёт (deposit) конвертированную сумму на счёт to.
    //Добавляет в оба счёта транзакции с типами "Transfer out" и "Transfer in".
    //Возвращает true, если перевод прошёл успешно, иначе — false:

    public static boolean transfer(BankAccount from, BankAccount to, double amount){

        if (from.withdraw(amount)){
            double convertedSum = ExchangeRate.convert(amount, from.getCurrency(), to.getCurrency());
            to.deposit(convertedSum);
            from.addTransaction("Transfer out", amount);
            to.addTransaction("Transfer in", convertedSum);
            return true;
        }
        return false;
    }


}
