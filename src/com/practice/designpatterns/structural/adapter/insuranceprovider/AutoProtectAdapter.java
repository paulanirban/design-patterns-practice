package com.practice.designpatterns.structural.adapter.insuranceprovider;

import com.practice.designpatterns.structural.adapter.insuranceprovider.external.AutoProtectApi;

public class AutoProtectAdapter implements TravelInsuranceAdapter {
    AutoProtectApi api = new AutoProtectApi();
    @Override
    public void add(String reference, Double amount) {
        api.addClaim(amount);
    }

    @Override
    public ClaimStatus get(String reference) {
        switch (api.getStatus(reference)) {
            case APPROVED:
                return ClaimStatus.APPROVED;
            case DENIED:
                return ClaimStatus.DENIED;
            default:
                return ClaimStatus.PENDING;
        }
    }
}
