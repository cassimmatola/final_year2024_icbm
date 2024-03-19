package com.project.gradingmanagementsystem.Teacher.Form_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.project.gradingmanagementsystem.R;

public class Form_1Activity extends AppCompatActivity {
    Button term1,term2,term3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);

        term1 = findViewById(R.id.button_form_1_term_1);
        term2 = findViewById(R.id.button_form_1_term_2);
        term3 = findViewById(R.id.button_form_1_term_3);

        term1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OneTerm_1Activity.class);
                startActivity(intent);
                finish();
            }
        });
        term2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OneTerm_2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        term3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OneTerm_3Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}