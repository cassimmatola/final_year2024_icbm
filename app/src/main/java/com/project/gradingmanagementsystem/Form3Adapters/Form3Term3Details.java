package com.project.gradingmanagementsystem.Form3Adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.gradingmanagementsystem.R;

public class Form3Term3Details extends AppCompatActivity {



    TextView Date,SClass,Term,Teacher,StudentName,Agriculture,Biology,Chemistry,Chichewa,
            English,Geography,Mathematics,Physics,SocialStudies,Total,Average,Grade;

    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marks_details);

        StudentName = findViewById(R.id.m_student);
        Agriculture = findViewById(R.id.m_agr);
        Biology = findViewById(R.id.m_bio);
        Chemistry = findViewById(R.id.m_chem);
        Chichewa = findViewById(R.id.m_chi);
        English = findViewById(R.id.m_eng);
        Geography= findViewById(R.id.m_geo);
        Mathematics= findViewById(R.id.m_maths);
        Physics = findViewById(R.id.m_phys);
        SocialStudies= findViewById(R.id.m_social);
        Total= findViewById(R.id.m_total);
        Average= findViewById(R.id.m_average);
        Grade= findViewById(R.id.m_grade);
        btnEdit = findViewById(R.id.button_m_edit);

        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            Agriculture.setText(bundle.getString("Agriculture"));
            StudentName.setText(bundle.getString("Student Name"));
            Biology.setText(bundle.getString("Biology"));
            Physics.setText(bundle.getString("Physics"));
            English.setText(bundle.getString("English"));
            Chemistry.setText(bundle.getString("Chemistry"));
            Chichewa.setText(bundle.getString("Chichewa"));
            Mathematics.setText(bundle.getString("Mathematics"));
            Geography.setText(bundle.getString("Geography"));
            SocialStudies.setText(bundle.getString("SocialStudies"));
            Grade.setText(bundle.getString("Grade"));
            Average.setText(bundle.getString("Average"));
            Total.setText(bundle.getString("Total"));
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Form3Term3Details.this, Form3Term3Update.class);
                intent.putExtra("Agriculture",Agriculture.getText().toString());
                intent.putExtra("Student Name",StudentName.getText().toString());
                intent.putExtra("Biology",Biology.getText().toString());
                intent.putExtra("Physics",Physics.getText().toString());
                intent.putExtra("English",English.getText().toString());
                intent.putExtra("Chemistry",Chemistry.getText().toString());
                intent.putExtra("Chichewa",Chichewa.getText().toString());
                intent.putExtra("Mathematics",Mathematics.getText().toString());
                intent.putExtra("Geography",Geography.getText().toString());
                intent.putExtra("SocialStudies",SocialStudies.getText().toString());
                intent.putExtra("Grade",Grade.getText().toString());
                intent.putExtra("Average",Average.getText().toString());
                intent.putExtra("Total",Total.getText().toString());

                startActivity(intent);
            }
        });
    }
}