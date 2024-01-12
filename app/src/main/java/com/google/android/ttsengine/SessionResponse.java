package com.google.android.ttsengine;

public class SessionResponse {
    private String message;
    private String voice;
    private int sessionId; // Note: naming convention in Java uses camelCase

    // Constructor
    public SessionResponse(String message, String voice, int sessionId) {
        this.message = message;
        this.voice = voice;
        this.sessionId = sessionId;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
}