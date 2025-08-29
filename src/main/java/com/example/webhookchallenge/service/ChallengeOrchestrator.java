package com.example.webhookchallenge.service;

import com.example.webhookchallenge.dto.WebhookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ChallengeOrchestrator implements CommandLineRunner {
    
    @Autowired
    private WebhookService webhookService;
    
    @Autowired
    private SqlSolverService sqlSolverService;
    
    // Update these with your actual details
    private static final String NAME = "John Doe";
    private static final String REG_NO = "REG12347"; // Update with your actual odd registration number
    private static final String EMAIL = "john@example.com";
    
    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("Starting VIT Java Webhook Challenge...");
            
            // Step 1: Generate webhook
            System.out.println("Step 1: Generating webhook...");
            WebhookResponse webhookResponse = webhookService.generateWebhook(NAME, REG_NO, EMAIL);
            
            // Step 2: Solve SQL problem (Question 1 since reg number is odd)
            System.out.println("Step 2: Solving SQL Question 1...");
            String sqlSolution = sqlSolverService.getActualSolution();
            
            // Step 3: Submit solution
            System.out.println("Step 3: Submitting solution...");
            webhookService.submitSolution(
                webhookResponse.getWebhook(), 
                webhookResponse.getAccessToken(), 
                sqlSolution
            );
            
            System.out.println("Challenge completed successfully!");
            
        } catch (Exception e) {
            System.err.println("Challenge failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
