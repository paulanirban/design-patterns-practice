package com.practice.designpatterns.structural.adapter.sample.services;

import com.practice.designpatterns.structural.adapter.sample.Bank;
import com.practice.designpatterns.structural.adapter.sample.externalapis.AxisApi;

public class AxisBankAdapter implements BankingService {
    private AxisApi api;

    public AxisBankAdapter(AxisApi api) {
        this.api = api;
    }

    @Override
    public void addBankAccount(Bank bank) {
        System.out.printf("Calling Axis bank API for registering bank account: %s", bank.name);
        api.addBankAccount(bank.name, bank.aadhaar, bank.pan, bank.dob, bank.fName);
    }

    @Override
    public boolean pay(double amount, String account) {
        return false;
    }

    @Override
    public double checkBalance(String account) {
        return 0;
    }
}
