package com.autobots.bankApp;

import java.util.HashMap;
import java.util.Map;

public class BankProApp {
    // создания клиентов и счетов, а также хранения клиентов в глобальной карте

    // Создаётся пустая Map<String, Client> clients — где ключом служит clientID:
    public static final Map<String, Client> clients = new HashMap<>();
    public static void main(String[] args) {

        // Создаётся клиент asan с именем и пином:
        Client asan = new Client("Asan Uson", "123");

        // Создаются два счёта: депозитный в USD и кредитный в EUR, оба принадлежат asan:
        DepositAccount asanDepositAccount = new DepositAccount(asan, Currency.USD);

        CreditAccount asanCreditAccount = new CreditAccount(asan, Currency.EUR);

        // Счета добавляются в список аккаунтов клиента.
        asan.addAccount(asanDepositAccount);
        asan.addAccount(asanCreditAccount);

        // Клиент добавляется в глобальную карту clients по его clientID.
        clients.put(asan.getClientID(), asan);
    }

}
