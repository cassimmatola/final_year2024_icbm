package com.project.gradingmanagementsystem.Admin;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.project.gradingmanagementsystem.R;
import com.project.gradingmanagementsystem.StudentInfo;
import com.project.gradingmanagementsystem.StudentInfoAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Nullable;


public class StudentFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<StudentInfo> studentInfoArrayList;
    StudentInfoAdapter studentInfoAdapter;
    private SearchView searchView;



    boolean valid = true;
    FirebaseFirestore fStore;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_student, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view_student_info);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        studentInfoArrayList = new ArrayList<StudentInfo>();
        studentInfoAdapter = new StudentInfoAdapter(getContext(), studentInfoArrayList);

        recyclerView.setAdapter(studentInfoAdapter); // Set the adapter for the RecyclerView

        fStore = FirebaseFirestore.getInstance();

        searchView = rootView.findViewById(R.id.search);
        setupSearchView();


        InfoShow();

        FloatingActionButton fab = rootView.findViewById(R.id.fab_student_reg);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddNewStudentInfo();
            }
        });

        return rootView;
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
        ArrayList<StudentInfo> filteredList = new ArrayList<>();

        for (StudentInfo student : studentInfoArrayList) {
            if (student.getFullName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(student);
            }
        }

        // Update the RecyclerView with the filtered data
        studentInfoAdapter.filterList(filteredList);
    }



    private void InfoShow() {
        fStore.collection("Student Information").orderBy("FullName", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (value != null) {
                            studentInfoArrayList.clear(); // Clear the list before adding new data
                            for (DocumentChange documentChange : value.getDocumentChanges()) {
                                if (documentChange.getType() == DocumentChange.Type.ADDED) {
                                    studentInfoArrayList.add(documentChange.getDocument().toObject(StudentInfo.class));
                                }
                            }
                            studentInfoAdapter.notifyDataSetChanged(); // Notify adapter of data change
                        }
                    }
                });
    }

    private void AddNewStudentInfo() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.new_student, null);
        dialogBuilder.setView(dialogView);

        final EditText editName = dialogView.findViewById(R.id.editName);
        final EditText editphone = dialogView.findViewById(R.id.editPhone);
        final EditText editDOB = dialogView.findViewById(R.id.editDOB);
        final EditText editaddress = dialogView.findViewById(R.id.editAddress);
        final EditText edityear = dialogView.findViewById(R.id.editClass);
        final EditText editIdNo = dialogView.findViewById(R.id.editRollNo);
        Button btnAdd = dialogView.findViewById(R.id.btnRegister);

        editDOB.setOnClickListener(new View.OnClickListener() {
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
                        getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // Update the EditText with the selected date using SimpleDateFormat
                                Calendar selectedDate = new GregorianCalendar(year, month, dayOfMonth);
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                                editDOB.setText(dateFormat.format(selectedDate.getTime()));
                            }
                        },
                        year, month, day);

                datePickerDialog.show();
            }
        });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(editName);
                checkField(editphone);
                checkField(editDOB);
                checkField(editaddress);
                checkField(edityear);
                checkField(editIdNo);


                if (valid){
                    Toast.makeText(getContext(), "Student registered successfully", Toast.LENGTH_SHORT).show();
                    // Create a new student with a first and last name
                    Map<String, Object> student = new HashMap<>();
                    student.put("FullName", editName.getText().toString());
                    student.put("Phone", editphone.getText().toString());
                    student.put("DOB", editDOB.getText().toString());
                    student.put("Address", editaddress.getText().toString());
                    student.put("Year", edityear.getText().toString());
                    student.put("StudentID", editIdNo.getText().toString());

                    String currentData = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

                    // Add a new document with a generated ID
                    fStore.collection("Student Information")
                            .add(student)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                                    InfoShow();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w("TAG", "Error adding document", e);
                                }
                            });
                }




            }
        });


    }
    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Empty");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }

}