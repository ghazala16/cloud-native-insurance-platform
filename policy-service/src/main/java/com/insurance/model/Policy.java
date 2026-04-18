package com.insurance.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "policies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    @Id
    private String id;

    private String policyName;
    private String policyType;
    private double premiumAmount;
    private String holderName;
}