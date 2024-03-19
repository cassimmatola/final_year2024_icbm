package com.project.gradingmanagementsystem.Teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.gradingmanagementsystem.R;
import com.project.gradingmanagementsystem.Teacher.Form_1.Form_1Activity;
import com.project.gradingmanagementsystem.Teacher.Form_2.Form_2Activity;
import com.project.gradingmanagementsystem.Teacher.Form_3.Form_3Activity;
import com.project.gradingmanagementsystem.Teacher.Form_4.Form_4Activity;

public class ClassesActivity extends AppCompatActivity {

    Button form_1, form_2, form_3, form_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        form_3 = findViewById(R.id.button_form_3);
        form_1 = findViewById(R.id.button_form_1);
        form_2 = findViewById(R.id.button_form_2);
        form_4 = findViewById(R.id.button_form_4);

        form_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Form_1Activity.class);
                startActivity(intent);
                finish();
            }
        });
        form_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Form_2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        form_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Form_3Activity.class);
                startActivity(intent);
                finish();
            }
        });
        form_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Form_4Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}