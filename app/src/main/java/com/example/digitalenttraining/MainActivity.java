package com.example.digitalenttraining;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.digitalenttraining.api.APIActivity;
import com.example.digitalenttraining.crash.CrashActivity;
import com.example.digitalenttraining.firebasedb.TelkomFirebaseDatabaseActivity;
import com.example.digitalenttraining.glide.GlideActivity;
import com.example.digitalenttraining.list.ListViewActivity;
import com.example.digitalenttraining.lottie.LottieActivity;
import com.example.digitalenttraining.maps.MapsActivity;
import com.example.digitalenttraining.model.UserModel;
import com.example.digitalenttraining.remoteconfig.RemoteConfigActivity;
import com.example.digitalenttraining.sqlite.MainSqliteActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    private Button btn_pindah;
    private Button btn_day_2;
    private Button btn_day_2_api;
    private Button btn_day_3_glide;
    private Button btn_maps;
    private Button btn_sqlite;
    private Button btn_unsub;
    private Button btn_sub;
    private Button btn_write;
    private Button btn_crash;
    private Button btn_lottie;
    private Button btn_remote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("TAG", "Hello World");

        btn_pindah = findViewById(R.id.btn_pindah);
        btn_day_2 = findViewById(R.id.btn_day_2);
        btn_day_2_api = findViewById(R.id.btn_day_2_api);
        btn_day_3_glide = findViewById(R.id.btn_day_3_glide);
        btn_maps = findViewById(R.id.btn_maps);
        btn_sqlite = findViewById(R.id.btn_sqlite);
        btn_unsub = findViewById(R.id.btn_unsub);
        btn_sub = findViewById(R.id.btn_sub);
        btn_write = findViewById(R.id.btn_write);
        btn_crash = findViewById(R.id.btn_crash);
        btn_lottie = findViewById(R.id.btn_lottie);
        btn_remote = findViewById(R.id.btn_remote);

        UserModel userModel = new UserModel("Try", "Tangerang", 21);

        btn_pindah.setOnClickListener(v -> {
            Intent activityTwo = new Intent(getApplicationContext(), ActivityTwo.class);
            activityTwo.putExtra("isiTextView", "Ini isi text view");
            activityTwo.putExtra("parcelable", userModel);
            startActivity(activityTwo);
        });

        btn_day_2.setOnClickListener(v->{
            Intent day2 = new Intent(getApplicationContext(), ListViewActivity.class);
            startActivity(day2);
        });

        btn_day_2_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day2_api = new Intent(getApplicationContext(), APIActivity.class);
                startActivity(day2_api);
            }
        });

        btn_day_3_glide.setOnClickListener(v->{
            Intent glide = new Intent(getApplicationContext(), GlideActivity.class);
            startActivity(glide);
        });

        btn_maps.setOnClickListener(v->{
            Intent maps = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(maps);
        });

        btn_sqlite.setOnClickListener(v->{
            Intent sqlite = new Intent(getApplicationContext(), MainSqliteActivity.class);
            startActivity(sqlite);
        });

        getDeviceToken();
        subscribeToTopic();

        btn_unsub.setOnClickListener(v->{
            FirebaseMessaging.getInstance().unsubscribeFromTopic("telkom").addOnSuccessListener(aVoid -> {
                Log.i("FCM", "Success unsubscribe from Telkom");
            });
        });

        btn_sub.setOnClickListener(v->{
            subscribeToTopic();
        });

        btn_write.setOnClickListener(v->{
            Intent firebaseDatabase = new Intent(getApplicationContext(), TelkomFirebaseDatabaseActivity.class);
            startActivity(firebaseDatabase);
        });

        btn_crash.setOnClickListener(v->{
           Intent crash = new Intent(getApplicationContext(), CrashActivity.class);
           startActivity(crash);
        });

        btn_lottie.setOnClickListener(v->{
            Intent lottie = new Intent(getApplicationContext(), LottieActivity.class);
            startActivity(lottie);
        });

        btn_remote.setOnClickListener(v->{
            Intent remote = new Intent(getApplicationContext(), RemoteConfigActivity.class);
            startActivity(remote);
        });
    }

    private void getDeviceToken(){
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if(!task.isSuccessful()){
                Log.e("Error FCM", "Can't get device token");
                return;
            }

            String token = task.getResult();
            Log.i("Token FCM", "Token = "+token);
        });
    }

    private void subscribeToTopic(){
        FirebaseMessaging.getInstance().subscribeToTopic("telkom").addOnSuccessListener(aVoid ->
                Log.i("Topic FCM", "Succes subscribe to Telkom"));
    }
}