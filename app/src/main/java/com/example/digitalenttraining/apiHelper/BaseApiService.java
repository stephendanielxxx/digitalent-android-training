package com.example.digitalenttraining.apiHelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {

    @GET("everything?q=tesla&from=2021-02-03&sortBy=publishedAt&apiKey=83297cabc0f946d2b2f50e46d6c4e068")
    Call<ResponseBody> getTeslaNews();

}
