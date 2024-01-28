package com.practice.designpatterns.structural.adapter.sample.services;

import com.practice.designpatterns.structural.adapter.sample.Bank;
import com.practice.designpatterns.structural.adapter.sample.externalapis.ICICIApi;

public class IciciBankAdapter extends BankingService {
    ICICIApi api;

    public IciciBankAdapter(ICICIApi api) {
        this.api = api;
    }


    @Override
    public void addBankAccount(Bank bank) {
        System.out.printf("Calling ICICI bank API for registering bank account: %s", bank.name);
        api.addBankAccount(bank.name, bank.aadhaar, bank.pan);
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
