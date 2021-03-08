package com.example.digitalenttraining.firebasedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.digitalenttraining.R;
import com.example.digitalenttraining.model.OfficeModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TelkomFirebaseDatabaseActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private DatabaseReference listenerReference;

    private EditText et_name;
    private EditText et_address;
    private EditText et_employee;
    private EditText et_latitude;
    private EditText et_longitude;
    private Button btn_submit_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telkom_firebase_database);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        listenerReference = FirebaseDatabase.getInstance().getReference().child("telkom");

        et_name = findViewById(R.id.et_name);
        et_address = findViewById(R.id.et_address);
        et_employee = findViewById(R.id.et_employee);
        et_latitude = findViewById(R.id.et_latitude);
        et_longitude = findViewById(R.id.et_longitude);
        btn_submit_data = findViewById(R.id.btn_submit_data);

        btn_submit_data.setOnClickListener(v->{
            String name = et_name.getText().toString();
            String address = et_address.getText().toString();
            int employee = Integer.parseInt(et_employee.getText().toString());
            double latitude = Double.parseDouble(et_latitude.getText().toString());
            double longitude = Double.parseDouble(et_longitude.getText().toString());

            OfficeModel officeModel = new OfficeModel(name, address, employee, latitude, longitude);

            databaseReference.child("telkom").child(officeModel.getName()).setValue(officeModel);

        });

        listenerReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("FDB", "Data changed "+snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FDB", "Error firebase database");
            }
        });
    }


}