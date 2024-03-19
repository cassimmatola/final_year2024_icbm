package com.project.gradingmanagementsystem.Form1Adapters;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.project.gradingmanagementsystem.R;

import java.util.HashMap;
import java.util.Map;

public class Form1Term1Update extends AppCompatActivity {
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_mark);

        final EditText updateStudent =findViewById(R.id.update_m_student);
        final EditText updateagr =findViewById(R.id.update_m_agr);
        final EditText updatebio =findViewById(R.id.update_m_bio);
        final EditText updatephys =findViewById(R.id.update_m_phys);
        final EditText updatechem =findViewById(R.id.update_m_chem);
        final EditText updateeng =findViewById(R.id.update_m_eng);
        final EditText updatechi =findViewById(R.id.update_m_chi);
        final EditText updatemaths =findViewById(R.id.update_m_maths);
        final EditText updategeo =findViewById(R.id.update_m_geo);
        final EditText updatesocial = findViewById(R.id.update_m_social);
        final EditText updategrade = findViewById(R.id.update_m_grade);
        final EditText updateavrg = findViewById(R.id.update_m_average);
        final EditText updatetotal = findViewById(R.id.update_m_total);
        Button updateok = findViewById(R.id.update_m_ok);
        Button update = findViewById(R.id.update_m_update);

        fStore = FirebaseFirestore.getInstance();

        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){

            updateStudent.setText(bundle.getString("Student Name"));
            updateagr.setText(bundle.getString("Agriculture"));
            updatebio.setText(bundle.getString("Biology"));
            updatephys.setText(bundle.getString("Physics"));
            updatechem.setText(bundle.getString("Chemistry"));
            updateeng.setText(bundle.getString("English"));
            updatechi.setText(bundle.getString("Chichewa"));
            updatemaths.setText(bundle.getString("Mathematics"));
            updategeo.setText(bundle.getString("Geography"));
            updatesocial.setText(bundle.getString("SocialStudies"));
            updategrade.setText(bundle.getString("Grade"));
            updateavrg.setText(bundle.getString("Average"));
            updatetotal.setText(bundle.getString("Total"));

        }

        updateok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int agr, bio, chem, chi, eng, geo, maths, phys, social, total;
                double average;

                agr = Integer.parseInt(updateagr.getText().toString());
                bio = Integer.parseInt(updatebio.getText().toString());
                chem = Integer.parseInt(updatechem.getText().toString());
                chi = Integer.parseInt(updatechi.getText().toString());
                eng = Integer.parseInt(updateeng.getText().toString());
                geo = Integer.parseInt(updategeo.getText().toString());
                maths = Integer.parseInt(updatemaths.getText().toString());
                phys = Integer.parseInt(updatephys.getText().toString());
                social = Integer.parseInt(updatesocial.getText().toString());

                total = agr + bio + chem + chi + eng + geo + maths + phys + social;
                updatetotal.setText(String.valueOf(total));

                average = total / 9;
                updateavrg.setText(String.valueOf(average));

                if (average >= 75) {
                    updategrade.setText("A");
                } else if (average >= 65) {
                    updategrade.setText("B");
                } else if (average >= 55) {
                    updategrade.setText("C");
                } else if (average >= 45) {
                    updategrade.setText("D");
                } else {
                    updategrade.setText("Fail");
                }
            }

        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> record = new HashMap<>();
                record.put("StudentName", updateStudent.getText().toString());
                record.put("Agriculture", updateagr.getText().toString());
                record.put("Biology", updatebio.getText().toString());
                record.put("Chemistry",updatechem.getText().toString());
                record.put("Chichewa", updatechi.getText().toString());
                record.put("English", updateeng.getText().toString());
                record.put("Geography", updategeo.getText().toString());
                record.put("Mathematics", updatemaths.getText().toString());
                record.put("Physics", updatephys.getText().toString());
                record.put("SocialStudies", updatesocial.getText().toString());
                record.put("Total", updatetotal.getText().toString());
                record.put("Average", updateavrg.getText().toString());
                record.put("Grade", updategrade.getText().toString());

                fStore.collection("Form One Term One Student Records")
                        .add(record)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("TAG", "record updated with  " + documentReference + "StudentName");


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("TAG", "Error adding record", e);
                            }
                        });

            }
        });

    }
}