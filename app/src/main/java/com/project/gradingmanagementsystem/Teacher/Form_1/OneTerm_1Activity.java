package com.project.gradingmanagementsystem.Teacher.Form_1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.project.gradingmanagementsystem.Form1Adapters.Form1;
import com.project.gradingmanagementsystem.Form1Adapters.Form1Term1;
import com.project.gradingmanagementsystem.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class OneTerm_1Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Form1>  form1s;
    Form1Term1 form1Term1;
    FirebaseFirestore fStore;
    private SearchView searchView;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_term1);

        recyclerView = findViewById(R.id.recycler_Form_1_Term_1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        form1s = new ArrayList<>();
        form1Term1 = new Form1Term1(this, form1s);  // Fixed variable name

        recyclerView.setAdapter(form1Term1);  // Fixed variable name
        fStore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();


        searchView = findViewById(R.id.search_Form_1_Term_1);
        setupSearchView();

        InfoShow();
        FloatingActionButton fab = findViewById(R.id.fab_Form_1_Term_1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMarkOne();

            }
        });
    }

    private void InfoShow() {
        fStore.collection("Form One Term One Student Records")
                .orderBy("StudentName", Query.Direction.ASCENDING)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        form1s.clear();
                        for (DocumentSnapshot document : queryDocumentSnapshots) {
                            Form1 info = document.toObject(Form1.class);
                            form1s.add(info);
                        }
                        form1Term1.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Handle the failure
                    }
                });
    }

    private void addMarkOne() {

        // Create an AlertDialog.Builder
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        // Inflate a custom view for the dialog
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_record_one_1, null);

        // Set the custom view for the dialog
        dialogBuilder.setView(dialogView);

        // Create the AlertDialog
        AlertDialog alertDialog = dialogBuilder.create();

        // Show the AlertDialog
        alertDialog.show();

        final EditText date, m_class, term, teacher, s_name, m_agr, m_bio, m_chem, m_chi, m_eng,
                m_geo, m_maths, m_phys, m_social, m_total, m_average, m_grade;
        Button ok, save, clear;


        date = dialogView.findViewById(R.id.m_date);
        teacher = dialogView.findViewById(R.id.m_teacher);
        s_name = dialogView.findViewById(R.id.m_student);
        m_agr = dialogView.findViewById(R.id.m_agr);
        m_bio = dialogView.findViewById(R.id.m_bio);
        m_chem = dialogView.findViewById(R.id.m_chem);
        m_chi = dialogView.findViewById(R.id.m_chi);
        m_eng = dialogView.findViewById(R.id.m_eng);
        m_geo = dialogView.findViewById(R.id.m_geo);
        m_maths = dialogView.findViewById(R.id.m_maths);
        m_phys = dialogView.findViewById(R.id.m_phys);
        m_social = dialogView.findViewById(R.id.m_social);
        m_total = dialogView.findViewById(R.id.m_total);
        m_average = dialogView.findViewById(R.id.m_average);
        m_grade = dialogView.findViewById(R.id.m_grade);

        FirebaseUser fullName  = mAuth.getCurrentUser();
        if (fullName  != null) {
            // User is signed in
            String userName = fullName.getDisplayName();

            // Set the user's name in the TextView
            teacher.setText(userName);
        } else {
            // No user is signed in, handle accordingly
            teacher.setText("");
        }
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }

            private void showDatePickerDialog() {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getApplicationContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // Update the EditText with the selected date using SimpleDateFormat
                                Calendar selectedDate = new GregorianCalendar(year, month, dayOfMonth);
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                                ActionBar.Tab date = null;
                                date.setText(dateFormat.format(selectedDate.getTime()));
                            }
                        },
                        year, month, day);

                datePickerDialog.show();
            }
        });





        ok = dialogView.findViewById(R.id.m_ok);
        save = dialogView.findViewById(R.id.m_save);
        clear = dialogView.findViewById(R.id.m_clear);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int agr, bio, chem, chi, eng, geo, maths, phys, social, total;
                double average;

                agr = Integer.parseInt(m_agr.getText().toString());
                bio = Integer.parseInt(m_bio.getText().toString());
                chem = Integer.parseInt(m_chem.getText().toString());
                chi = Integer.parseInt(m_chi.getText().toString());
                eng = Integer.parseInt(m_eng.getText().toString());
                geo = Integer.parseInt(m_geo.getText().toString());
                maths = Integer.parseInt(m_maths.getText().toString());
                phys = Integer.parseInt(m_phys.getText().toString());
                social = Integer.parseInt(m_social.getText().toString());

                total = agr + bio + chem + chi + eng + geo + maths + phys + social;
                m_total.setText(String.valueOf(total));

                average = total / 9;
                m_average.setText(String.valueOf(average));

                if (average >= 75) {
                    m_grade.setText("A");
                } else if (average >= 65) {
                    m_grade.setText("B");
                } else if (average >= 55) {
                    m_grade.setText("C");
                } else if (average >= 45) {
                    m_grade.setText("D");
                } else {
                    m_grade.setText("Fail");
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Student record added successfully", Toast.LENGTH_SHORT).show();

                Map<String, Object> record = new HashMap<>();
                record.put("Date", date.getText().toString());
                record.put("Teacher", teacher.getText().toString());
                record.put("StudentName", s_name.getText().toString());
                record.put("Agriculture", m_agr.getText().toString());
                record.put("Biology", m_bio.getText().toString());
                record.put("Chemistry", m_chem.getText().toString());
                record.put("Chichewa", m_chi.getText().toString());
                record.put("English", m_eng.getText().toString());
                record.put("Geography", m_geo.getText().toString());
                record.put("Mathematics", m_maths.getText().toString());
                record.put("Physics", m_phys.getText().toString());
                record.put("SocialStudies", m_social.getText().toString());
                record.put("Total", m_total.getText().toString());
                record.put("Average", m_average.getText().toString());
                record.put("Grade", m_grade.getText().toString());

                fStore.collection("Form One Term One Student Records")
                        .add(record)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("TAG", "record added with  " + documentReference + "StudentName");
                                InfoShow();

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
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.setText("");
                teacher.setText("");
                s_name.setText("");
                m_agr.setText("");
                m_bio.setText("");
                m_chem.setText("");
                m_chi.setText("");
                m_eng.setText("");
                m_geo.setText("");
                m_maths.setText("");
                m_phys.setText("");
                m_social.setText("");
                m_total.setText("");
                m_average.setText("");
                m_grade.setText("");

                date.requestFocus();
            }
        });

    }



    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the dataset based on the search query
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String query) {
        ArrayList<Form1> filteredList = new ArrayList<>();

        for (Form1 info : form1s) {
            if (info.getStudentName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(info);
            }
        }

        // Update the RecyclerView with the filtered data
        form1Term1.filterList(filteredList);
    }
}