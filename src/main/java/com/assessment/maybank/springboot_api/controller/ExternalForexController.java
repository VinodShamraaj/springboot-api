package com.assessment.maybank.springboot_api.controller;

import com.assessment.maybank.springboot_api.service.ExternalForexService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forex")
@RequiredArgsConstructor
public class ExternalForexController {

    private final ExternalForexService externalForexService;

    @GetMapping
    public ResponseEntity<String> fetchForexRates() {
        String response = externalForexService.fetchForexRates();
        return ResponseEntity.ok(response);
    }
}
