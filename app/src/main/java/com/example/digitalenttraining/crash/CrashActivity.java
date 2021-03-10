package com.example.digitalenttraining.crash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.digitalenttraining.R;

public class CrashActivity extends AppCompatActivity {

    private Button btn_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);

        btn_error = findViewById(R.id.btn_sub);
        
        btn_error.setOnClickListener(v->{
            Toast.makeText(this, "Ini error", Toast.LENGTH_SHORT).show();
        });
    }
}