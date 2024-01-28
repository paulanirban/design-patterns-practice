package com.practice.designpatterns.structural.adapter.insuranceprovider.external;

import com.practice.designpatterns.structural.adapter.insuranceprovider.ApiUtils;

public class TravelGuardApi {
    public void submitClaim(String id, Double amount) {
        ApiUtils.logTravelGuardClaimCall();
    }

    public String getClaimStatus(String id) {
        ApiUtils.logTravelGuardStatusCall();
        return "SUCCESS";
    }
}
