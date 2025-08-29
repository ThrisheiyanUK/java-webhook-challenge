package com.example.webhookchallenge.service;

import com.example.webhookchallenge.dto.WebhookRequest;
import com.example.webhookchallenge.dto.WebhookResponse;
import com.example.webhookchallenge.dto.SolutionRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

@Service
public class WebhookService {
    
    private final WebClient webClient;
    
    public WebhookService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    
    public WebhookResponse generateWebhook(String name, String regNo, String email) {
        WebhookRequest request = new WebhookRequest(name, regNo, email);
        
        try {
            WebhookResponse response = webClient.post()
                .uri("https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(WebhookResponse.class)
                .block();
            
            System.out.println("Webhook generated successfully!");
            System.out.println("Webhook URL: " + response.getWebhook());
            System.out.println("Access Token received");
            
            return response;
        } catch (Exception e) {
            System.err.println("Error generating webhook: " + e.getMessage());
            throw new RuntimeException("Failed to generate webhook", e);
        }
    }
    
    public void submitSolution(String webhookUrl, String accessToken, String sqlQuery) {
        SolutionRequest solution = new SolutionRequest(sqlQuery);
        
        try {
            String response = webClient.post()
                .uri(webhookUrl)
                .header(HttpHeaders.AUTHORIZATION, accessToken)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(solution)
                .retrieve()
                .bodyToMono(String.class)
                .block();
            
            System.out.println("Solution submitted successfully!");
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.err.println("Error submitting solution: " + e.getMessage());
            throw new RuntimeException("Failed to submit solution", e);
        }
    }
}
