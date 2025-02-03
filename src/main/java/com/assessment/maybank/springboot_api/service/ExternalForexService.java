package com.assessment.maybank.springboot_api.service;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class ExternalForexService {

    private final RestTemplate restTemplate;
    HttpHeaders headers = new HttpHeaders();

    public ExternalForexService() {
        this.restTemplate = new RestTemplate();
    }

    // Fetches the current foreign exchange rates from Bank Negara API
    public String fetchForexRates() {
        // Bank Negara API Url
        String url = "https://api.bnm.gov.my/public/exchange-rate";
        
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.BNM.API.v1+json");

        // Create the HttpEntity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        // Make Request
        ResponseEntity<String> response = restTemplate.exchange(
                url, 
                HttpMethod.GET, 
                entity, 
                String.class);

        return response.getBody();
    }
}
