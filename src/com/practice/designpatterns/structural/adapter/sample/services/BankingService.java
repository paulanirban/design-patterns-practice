package com.practice.designpatterns.structural.adapter.sample.services;

import com.practice.designpatterns.structural.adapter.sample.Bank;

public interface BankingService {
    void addBankAccount(Bank bank);
    boolean pay(double amount, String account);
    double checkBalance(String account);
}
