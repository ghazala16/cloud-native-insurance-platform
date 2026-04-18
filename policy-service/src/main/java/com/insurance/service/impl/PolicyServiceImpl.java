package com.insurance.service.impl;

import com.insurance.dto.PolicyRequest;
import com.insurance.dto.PolicyResponse;
import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.Policy;
import com.insurance.repository.PolicyRepository;
import com.insurance.service.PolicyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public PolicyResponse createPolicy(PolicyRequest request) {
        Policy policy = new Policy(
                null,
                request.getPolicyName(),
                request.getPolicyType(),
                request.getPremiumAmount(),
                request.getHolderName()
        );

        Policy saved = policyRepository.save(policy);
        return mapToResponse(saved);
    }

    @Override
    public List<PolicyResponse> getAllPolicies() {
        return policyRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PolicyResponse getPolicyById(String id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));

        return mapToResponse(policy);
    }

    @Override
    public PolicyResponse updatePolicy(String id, PolicyRequest request) {
        Policy existing = policyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));

        existing.setPolicyName(request.getPolicyName());
        existing.setPolicyType(request.getPolicyType());
        existing.setPremiumAmount(request.getPremiumAmount());
        existing.setHolderName(request.getHolderName());

        Policy updated = policyRepository.save(existing);
        return mapToResponse(updated);
    }

    @Override
    public void deletePolicy(String id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));

        policyRepository.delete(policy);
    }

    // 🔥 Mapper Method (VERY IMPORTANT)
    private PolicyResponse mapToResponse(Policy policy) {
        return PolicyResponse.builder()
                .id(policy.getId())
                .policyName(policy.getPolicyName())
                .policyType(policy.getPolicyType())
                .premiumAmount(policy.getPremiumAmount())
                .holderName(policy.getHolderName())
                .build();
    }
}