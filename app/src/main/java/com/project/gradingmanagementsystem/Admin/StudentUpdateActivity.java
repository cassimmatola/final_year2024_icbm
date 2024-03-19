package com.project.gradingmanagementsystem.Admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.gradingmanagementsystem.R;

import java.util.HashMap;
import java.util.Map;

public class StudentUpdateActivity extends AppCompatActivity {

    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        final EditText updateFullName = findViewById(R.id.updateName);
        final EditText updatePhone = findViewById(R.id.updatePhone);
        final EditText updateAddress = findViewById(R.id.updateAddress);
        final EditText updateDOB = findViewById(R.id.updateDOB);
        final EditText updateYear = findViewById(R.id.updateClass);
        final EditText updateId = findViewById(R.id.updateRollNo);
        final Button btnUpdate = findViewById(R.id.btnupdate);

        fStore = FirebaseFirestore.getInstance();


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            updateFullName.setText(bundle.getString("Student Name"));
            updatePhone.setText(bundle.getString("phone"));
            updateDOB.setText(bundle.getString("DOB"));
            updateAddress.setText(bundle.getString("address"));
            updateYear.setText(bundle.getString("year"));
            updateId.setText(bundle.getString("Student Id"));
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assuming you have the document ID in updateId.getText().toString()
                String documentId = updateId.getText().toString();

                Map<String, Object> student = new HashMap<>();
                student.put("FullName", updateFullName.getText().toString());
                student.put("Phone", updatePhone.getText().toString());
                student.put("DOB", updateDOB.getText().toString());
                student.put("Address", updateAddress.getText().toString());
                student.put("Year", updateYear.getText().toString());

                // Update the existing document
                fStore.collection("Student Information")
                        .document(documentId)
                        .update(student)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "Error While Updating", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });


    }


}
