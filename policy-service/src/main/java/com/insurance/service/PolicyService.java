package com.insurance.service;

import com.insurance.dto.PolicyRequest;
import com.insurance.dto.PolicyResponse;

import java.util.List;

public interface PolicyService {

    PolicyResponse createPolicy(PolicyRequest request);

    List<PolicyResponse> getAllPolicies();

    PolicyResponse getPolicyById(String id);

    PolicyResponse updatePolicy(String id, PolicyRequest request);

    void deletePolicy(String id);
}