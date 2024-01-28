package com.practice.designpatterns.structural.adapter.insuranceprovider;

public interface TravelInsuranceAdapter {
    void add(String reference, Double amount);
    ClaimStatus get(String reference);
}
