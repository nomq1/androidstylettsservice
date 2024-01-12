package com.google.android.ttsengine;

public class TtsRequest {
    private String sessionId;
    private String text;
    private Float alpha; // Assuming these are Floats, can be changed to Integer if needed
    private Float beta;
    private Integer diffusionSteps;
    private Float embeddingScale;

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

    public Float getAlpha() {
        return alpha;
    }

    public void setAlpha(Float alpha) {
        this.alpha = alpha;
    }

    public Float getBeta() {
        return beta;
    }

    public void setBeta(Float beta) {
        this.beta = beta;
    }

    public Integer getDiffusionSteps() {
        return diffusionSteps;
    }

    public void setDiffusionSteps(Integer diffusionSteps) {
        this.diffusionSteps = diffusionSteps;
    }

    public Float getEmbeddingScale() {
        return embeddingScale;
    }

    public void setEmbeddingScale(Float embeddingScale) {
        this.embeddingScale = embeddingScale;
    }

    // Constructor
    public TtsRequest(String sessionId, String text, Float alpha, Float beta, Integer diffusionSteps, Float embeddingScale) {
        this.sessionId = sessionId;
        this.text = text;
        this.alpha = alpha;
        this.beta = beta;
        this.diffusionSteps = diffusionSteps;
        this.embeddingScale = embeddingScale;
    }

    // Getters and Setters
    // ... (Generate getters and setters for each field)
}
