package com.example.pothole_detection_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Form extends AppCompatActivity {
    EditText pothole_location ,ans1,ans2,ans3;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        pothole_location = findViewById(R.id.found_pothole_address);
        ans1 = findViewById(R.id.edanswer1);
        ans2 = findViewById(R.id.edanswer2);
        ans3 = findViewById(R.id.edanswer3);
        submit = findViewById(R.id.btnupload);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Form.this,detection_model.class));
            }
        });

    }
}