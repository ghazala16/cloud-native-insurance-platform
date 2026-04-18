package com.insurance.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PolicyResponse {
    private String id;
    private String policyName;
    private String policyType;
    private double premiumAmount;
    private String holderName;
}