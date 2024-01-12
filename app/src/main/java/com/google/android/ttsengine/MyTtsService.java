package com.google.android.ttsengine;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.speech.tts.TextToSpeechService;
import java.util.Locale;
import android.speech.tts.TextToSpeech;
import android.speech.tts.SynthesisRequest;
import android.speech.tts.SynthesisCallback;

public class MyTtsService extends TextToSpeechService {

    @Override
    protected int onIsLanguageAvailable(String lang, String country, String variant) {
        // Check if the language is English
        return lang.equals(Locale.ENGLISH.getISO3Language()) ? TextToSpeech.LANG_AVAILABLE : TextToSpeech.LANG_NOT_SUPPORTED;
    }

    @Override
    protected String[] onGetLanguage() {
        // Return the currently supported language - English
        return new String[] { "eng", "", "" };
    }

    @Override
    protected int onLoadLanguage(String lang, String country, String variant) {
        // Load and return the result for the English language
        return onIsLanguageAvailable(lang, country, variant);
    }

    @Override
    protected void onStop() {
        // Stop any ongoing TTS
    }

    @Override
    protected void onSynthesizeText(SynthesisRequest request, SynthesisCallback callback) {
        String textToSynthesize = request.getCharSequenceText().toString();
        // Make sure to replace this URL with your actual API's base URL
        String baseUrl = BuildConfig.API_BASE_URL;

        try {
            // Set up Retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            // Create an instance of your API service
            TtsApiService apiService = retrofit.create(TtsApiService.class);

            // Prepare TTS request
            TtsRequest ttsRequest = new TtsRequest(/* sessionId, text, and other parameters */);

            // Make a synchronous API call to your TTS service
            Call<ResponseBody> call = apiService.performTts(ttsRequest);
            Response<ResponseBody> response = call.execute();

            if (response.isSuccessful() && response.body() != null) {
                // Assuming the API returns the audio data directly
                byte[] audioData = response.body().bytes();

                // Provide synthesized speech data to the callback
                callback.start(request.getSampleRateInHz(), AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
                callback.audioAvailable(audioData, 0, audioData.length);
                callback.done();
            } else {
                // Handle the error
                callback.error();
            }
        } catch (Exception e) {
            callback.error();
            e.printStackTrace();
        }
    }
    }
}