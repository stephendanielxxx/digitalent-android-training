package com.example.digitalenttraining.apiHelper;

public class UtilsApi {

    public static final String BASE_URL_API = "https://newsapi.org/v2/";

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
