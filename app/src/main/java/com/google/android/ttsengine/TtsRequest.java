package com.google.android.ttsengine;

public class TtsRequest {
    private String sessionId;
    private String text;
    private Double alpha; // Assuming these are Floats, can be changed to Integer if needed
    private Double beta;
    private Integer diffusionSteps;
    private Double embeddingScale;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getAlpha() {
        return alpha;
    }

    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    public Double getBeta() {
        return beta;
    }

    public void setBeta(Double beta) {
        this.beta = beta;
    }

    public Integer getDiffusionSteps() {
        return diffusionSteps;
    }

    public void setDiffusionSteps(Integer diffusionSteps) {
        this.diffusionSteps = diffusionSteps;
    }

    public Double getEmbeddingScale() {
        return embeddingScale;
    }

    public void setEmbeddingScale(Double embeddingScale) {
        this.embeddingScale = embeddingScale;
    }

    // Constructor
    public TtsRequest(String sessionId, String text, Double alpha, Double beta, Integer diffusionSteps, Double embeddingScale) {
        this.sessionId = sessionId;
        this.text = text;
        this.alpha = alpha;
        this.beta = beta;
        this.diffusionSteps = diffusionSteps;
        this.embeddingScale = embeddingScale;
    }

    public TtsRequest(String sessionId, String text) {
        this.sessionId = sessionId;
        this.text = text;
        this.alpha = 0.2;
        this.beta = 0.4;
        this.diffusionSteps = 10;
        this.embeddingScale = 1.5;
    }

    // Getters and Setters
    // ... (Generate getters and setters for each field)
}
