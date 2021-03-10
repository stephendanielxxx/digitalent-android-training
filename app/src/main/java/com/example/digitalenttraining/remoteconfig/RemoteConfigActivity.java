package com.example.digitalenttraining.remoteconfig;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.digitalenttraining.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class RemoteConfigActivity extends AppCompatActivity {

    private FirebaseRemoteConfig firebaseRemoteConfig;

    private Button btn_get_version;
    private Button btn_feature_a;
    private Button btn_feature_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_config);

        btn_get_version = findViewById(R.id.btn_get_version);
        btn_feature_a = findViewById(R.id.btn_feature_a);
        btn_feature_b = findViewById(R.id.btn_feature_b);

        //set instance
        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

        //configure
        FirebaseRemoteConfigSettings settings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(0)
                .build();

        firebaseRemoteConfig.setConfigSettingsAsync(settings);

        //fetch and activate

        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                boolean result = task.getResult();
                Log.i("Remote Config", "Result = "+result);

                checkFeature();
            }
        });

        btn_get_version.setOnClickListener(v->{
            int currentVersion = getVersionCode(); // 1
            String minVersion = firebaseRemoteConfig.getString("min_version"); // 2
            int minVersionInt = Integer.parseInt(minVersion);
            if(currentVersion < minVersionInt){
                Toast.makeText(this, "Please update your app", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Your app is up to date", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void checkFeature(){
        if(firebaseRemoteConfig.getBoolean("FeatureA")){
            btn_feature_a.setVisibility(View.VISIBLE);
        }else{
            btn_feature_a.setVisibility(View.GONE);
        }

        if(firebaseRemoteConfig.getBoolean("FeatureB")){
            btn_feature_b.setVisibility(View.VISIBLE);
        }else {
            btn_feature_b.setVisibility(View.GONE);
        }
    }

    private int getVersionCode(){
        try{
            PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
            return packageInfo.versionCode;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}








