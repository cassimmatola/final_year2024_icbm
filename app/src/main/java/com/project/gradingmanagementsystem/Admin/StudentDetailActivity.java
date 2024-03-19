package com.project.gradingmanagementsystem.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.gradingmanagementsystem.R;

public class StudentDetailActivity extends AppCompatActivity {

     TextView FullName, Phone, DOB, Address, Year, StudentID;
     Button btnEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_details);


        FullName = findViewById(R.id.name);
        Phone = findViewById(R.id.Phone);
        DOB = findViewById(R.id.DOB);
        Address = findViewById(R.id.address);
        Year = findViewById(R.id.year);
        StudentID = findViewById(R.id.id);
        btnEdit = findViewById(R.id.button_edit);



        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            FullName.setText(bundle.getString("Student Name"));
            Phone.setText(bundle.getString("phone"));
            DOB.setText(bundle.getString(""));
            DOB.setText(bundle.getString("DOB"));
            Address.setText(bundle.getString("address"));
            Year.setText(bundle.getString("year"));
            StudentID.setText(bundle.getString("Student Id"));

        }



        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StudentDetailActivity.this,StudentUpdateActivity.class);

                intent.putExtra("Student Name",FullName.getText().toString());
                intent.putExtra("phone",Phone.getText().toString());
                intent.putExtra("DOB",DOB.getText().toString());
                intent.putExtra("address",Address.getText().toString());
                intent.putExtra("year",Year.getText().toString());
                intent.putExtra("Student Id",StudentID.getText().toString());
                startActivity(intent);




            }
        });


    }
}