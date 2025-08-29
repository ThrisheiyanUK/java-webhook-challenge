package com.example.webhookchallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolutionRequest {
    @JsonProperty("finalQuery")
    private String finalQuery;

    public SolutionRequest() {}

    public SolutionRequest(String finalQuery) {
        this.finalQuery = finalQuery;
    }

    // Getters and setters
    public String getFinalQuery() {
        return finalQuery;
    }

    public void setFinalQuery(String finalQuery) {
        this.finalQuery = finalQuery;
    }
}
