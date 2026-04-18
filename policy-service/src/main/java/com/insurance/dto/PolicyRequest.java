package com.insurance.dto;

import lombok.Data;

@Data
public class PolicyRequest {
    private String policyName;
    private String policyType;
    private double premiumAmount;
    private String holderName;
}