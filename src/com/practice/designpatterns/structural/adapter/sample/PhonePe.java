package com.practice.designpatterns.structural.adapter.sample;

import com.practice.designpatterns.structural.adapter.sample.services.BankingService;

public class PhonePe {
    private BankingService bankingService;

    public PhonePe(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    void createBankAccount() {
        Bank bank = new Bank();
        bank.name = "John Doe";
        bank.pan = "KKKKK9900X";
        bank.aadhaar = "123456789";

        bankingService.addBankAccount(bank);
    }
}
