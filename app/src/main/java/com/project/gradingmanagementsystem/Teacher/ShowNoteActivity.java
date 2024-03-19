package com.project.gradingmanagementsystem.Teacher;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.project.gradingmanagementsystem.R;

public class ShowNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        String data1 = getIntent().getStringExtra("data1");
        String data2 = getIntent().getStringExtra("data2");
       // String data3 = getIntent().getStringExtra("data3");

        titleTextView.setText(data1);
        descriptionTextView.setText(data2);
        //fileInfoTextView.setText(data3);



    }
}