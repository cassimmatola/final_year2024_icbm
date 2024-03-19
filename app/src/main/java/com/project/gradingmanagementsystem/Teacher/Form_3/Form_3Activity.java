package com.project.gradingmanagementsystem.Teacher.Form_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.gradingmanagementsystem.R;
import com.project.gradingmanagementsystem.Teacher.Form_1.OneTerm_1Activity;
import com.project.gradingmanagementsystem.Teacher.Form_1.OneTerm_2Activity;
import com.project.gradingmanagementsystem.Teacher.Form_1.OneTerm_3Activity;
import com.project.gradingmanagementsystem.Teacher.Form_2.TwoTerm1Activity;
import com.project.gradingmanagementsystem.Teacher.Form_2.TwoTerm_2Activity;
import com.project.gradingmanagementsystem.Teacher.Form_2.TwoTerm_3Activity;

public class Form_3Activity extends AppCompatActivity {
    Button term1,term2,term3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form3);

        term1 = findViewById(R.id.button_form_3_term_1);
        term2 = findViewById(R.id.button_form_3_term_2);
        term3 = findViewById(R.id.button_form_3_term_3);

        term1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThreeTerm_1Activity.class);
                startActivity(intent);
                finish();
            }
        });
        term2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThreeTerm_2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        term3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThreeTerm_3Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}