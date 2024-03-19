package com.project.gradingmanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.project.gradingmanagementsystem.Admin.StudentDetailActivity;

import java.util.ArrayList;

public class StudentInfoAdapter extends RecyclerView.Adapter<StudentInfoAdapter.MyViewHolder> {

    Context context;
    ArrayList<StudentInfo> studentInfoArrayList;
    private OnItemClickListener listener;
    private ArrayList<StudentInfo> originalList;
    FirebaseFirestore fStore;

    public StudentInfoAdapter(Context context, ArrayList<StudentInfo> studentInfoArrayList) {
        this.context = context;
        this.studentInfoArrayList = studentInfoArrayList;
        this.listener = listener;
        this.originalList = new ArrayList<>(studentInfoArrayList);
        fStore = FirebaseFirestore.getInstance();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.student_data, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final StudentInfo studentInfo = studentInfoArrayList.get(position);

        holder.FullName.setText(studentInfo.FullName);
        holder.Phone.setText(studentInfo.Phone);

        holder.button_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StudentDetailActivity.class);
                intent.putExtra("Student Name",studentInfo.getFullName());
                intent.putExtra("phone",studentInfo.getPhone());
                intent.putExtra("DOB",studentInfo.getDOB());
                intent.putExtra("address",studentInfo.getAddress());
                intent.putExtra("year",studentInfo.getYear());
                intent.putExtra("Student Id",studentInfo.getStudentID());

                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return studentInfoArrayList.size();
    }

    public void filterList(ArrayList<StudentInfo> filteredList) {
        studentInfoArrayList = filteredList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView FullName, Phone;

        ImageButton button_more;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            FullName = itemView.findViewById(R.id.name);
            Phone = itemView.findViewById(R.id.Phone);
            button_more = itemView.findViewById(R.id.button_more);
        }
    }
}
