package com.practice.designpatterns.structural.adapter.insuranceprovider;

import com.practice.designpatterns.structural.adapter.insuranceprovider.external.TravelGuardApi;

public class TravelGuardAdapter implements TravelInsuranceAdapter {
    TravelGuardApi api = new TravelGuardApi();
    @Override
    public void add(String reference, Double amount) {
        api.submitClaim(reference, amount);
    }

    @Override
    public ClaimStatus get(String reference) {
        switch (api.getClaimStatus(reference)) {
            case "APPROVED":
                return ClaimStatus.APPROVED;
            case "DENIED":
                return ClaimStatus.DENIED;
            case "SUCCESS":
                return ClaimStatus.SUCCESS;
            default:
                return ClaimStatus.PENDING;
        }
    }
}
