package com.google.android.ttsengine;

import java.util.List;

public class VoicesResponse {
    private List<String> voices;

    // Constructor
    public VoicesResponse(List<String> voices) {
        this.voices = voices;
    }

    public void setVoices(List<String> voices) {
        this.voices = voices;
    }

    // Getter
    public List<String> getVoices() {
        return voices;
    }
}
