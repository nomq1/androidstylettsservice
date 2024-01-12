package com.google.android.ttsengine;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TtsApiService {
    @POST("/session/new")
    Call<SessionResponse> createSession(@Body RequestBody requestBody);

    @POST("/tts")
    Call<ResponseBody> performTts(@Body TtsRequest ttsRequest);

    @GET("/voices")
    Call<VoicesResponse> getAvailableVoices();
}
