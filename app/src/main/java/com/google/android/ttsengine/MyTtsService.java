package com.google.android.ttsengine;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.speech.tts.TextToSpeechService;
import java.util.Locale;
import android.speech.tts.TextToSpeech;
import android.speech.tts.SynthesisRequest;
import android.speech.tts.SynthesisCallback;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import okhttp3.*;
import android.media.AudioFormat;
import retrofit2.Call;
import retrofit2.Response;
import java.util.concurrent.TimeUnit;

public class MyTtsService extends TextToSpeechService {

    @Override
    protected int onIsLanguageAvailable(String lang, String country, String variant) {
        // Check if the language is English
        return lang.equals(Locale.ENGLISH.getISO3Language()) ? TextToSpeech.LANG_AVAILABLE : TextToSpeech.LANG_NOT_SUPPORTED;
    }

    @Override
    protected String[] onGetLanguage() {
        // Return the currently supported language - English
        return new String[] { "eng" };
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
        String baseUrl = "http://192.168.0.130:5050";

        try {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(10, TimeUnit.SECONDS)    // Read timeout (for waiting to read data)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient) // Set the custom client
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
//
            TtsApiService apiService = retrofit.create(TtsApiService.class);
//
//            // Create a session
//            // Modify this part based on what data your API expects for session creation
//            RequestBody sessionRequestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{}");
//            Call<SessionResponse> sessionCall = apiService.createSession(sessionRequestBody);
//            Response<SessionResponse> sessionResponse = sessionCall.execute();
//
//            if (!sessionResponse.isSuccessful() || sessionResponse.body() == null) {
//                callback.error();
//                return;
//            }

            String sessionId = "12345";

            // Step 2: Perform TTS with the session ID and text
            TtsRequest ttsRequest = new TtsRequest(sessionId, textToSynthesize /*, other parameters */);
            Call<ResponseBody> ttsCall = apiService.performTts(ttsRequest);
            Response<ResponseBody> ttsResponse = ttsCall.execute();

            if (ttsResponse.isSuccessful() && ttsResponse.body() != null) {
                byte[] audioData = ttsResponse.body().bytes();
                int chunkSize = 1024; // Adjust this size as needed
                int offset = 0;
                callback.start(22050,  AudioFormat.ENCODING_PCM_16BIT, 1 );
                while (offset < audioData.length) {
                    int bufferSize = Math.min(chunkSize, audioData.length - offset);
                    callback.audioAvailable(audioData, offset, bufferSize);
                    offset += bufferSize;
                }
                callback.done();
            } else {
                callback.error();
            }
        } catch (Exception e) {
            callback.error();
            e.printStackTrace();
        }
    }
    }
