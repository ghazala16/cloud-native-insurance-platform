package com.insurance.controller;

import com.insurance.dto.PolicyRequest;
import com.insurance.dto.PolicyResponse;
import com.insurance.service.PolicyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public PolicyResponse createPolicy(@RequestBody PolicyRequest request) {
        return policyService.createPolicy(request);
    }

    @GetMapping
    public List<PolicyResponse> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public PolicyResponse getPolicyById(@PathVariable String id) {
        return policyService.getPolicyById(id);
    }

    @PutMapping("/{id}")
    public PolicyResponse updatePolicy(@PathVariable String id,
                                       @RequestBody PolicyRequest request) {
        return policyService.updatePolicy(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable String id) {
        policyService.deletePolicy(id);
    }
}