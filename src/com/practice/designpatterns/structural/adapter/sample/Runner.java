package com.practice.designpatterns.structural.adapter.sample;

import com.practice.designpatterns.structural.adapter.sample.externalapis.AxisApi;
import com.practice.designpatterns.structural.adapter.sample.services.AxisBankAdapter;
import com.practice.designpatterns.structural.adapter.sample.services.BankingService;

public class Runner {
    public static void main(String[] args) {
        BankingService axisBankService = new AxisBankAdapter(new AxisApi());

        PhonePe phonePe = new PhonePe(axisBankService);
        phonePe.createBankAccount();
    }
}
