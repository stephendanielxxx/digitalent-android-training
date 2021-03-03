package com.example.digitalenttraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.digitalenttraining.apiHelper.BaseApiService;
import com.example.digitalenttraining.apiHelper.UtilsApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIActivity extends AppCompatActivity {
    BaseApiService baseApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_p_i);

        baseApiService = UtilsApi.getAPIService();

        getNewsTesla();
    }

    public void getNewsTesla(){
        baseApiService.getTeslaNews().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                Log.d("logNews", "onResponse: "+response);

                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(APIActivity.this, "Gagal mengambil data!"
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}