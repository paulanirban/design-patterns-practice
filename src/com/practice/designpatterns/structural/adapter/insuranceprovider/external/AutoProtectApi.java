package com.practice.designpatterns.structural.adapter.insuranceprovider.external;

import com.practice.designpatterns.structural.adapter.insuranceprovider.ApiUtils;

public class AutoProtectApi {
    public void addClaim(Double amount) {
        ApiUtils.logAutoProtectClaimCall();
    }

    public AutoProtectStatus getStatus(String id) {
        ApiUtils.logAutoProtectStatusCall();
        return AutoProtectStatus.APPROVED;
    }
}
