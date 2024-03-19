package com.project.gradingmanagementsystem.Form1Adapters;

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
import com.project.gradingmanagementsystem.R;

import java.util.ArrayList;

public class Form1Term1 extends RecyclerView.Adapter< Form1Term1.MyViewHolder>{

    private Context context;
    private ArrayList<Form1> form1s;
    FirebaseFirestore fStore;

    public Form1Term1(Context context, ArrayList<Form1> form1s) {
        this.context = context;
        this.form1s = form1s;
        this.fStore = fStore;
    }



    @NonNull
    @Override
    public Form1Term1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(context).inflate(R.layout.one_term_1_item,parent, false);
            return new MyViewHolder(v);
        }





    @Override
    public void onBindViewHolder(@NonNull final Form1Term1.MyViewHolder holder, int position) {
        fStore = FirebaseFirestore.getInstance();
        final Form1 form_1_infoList = form1s.get(position);

        holder.StudentName.setText(form_1_infoList.StudentName);
        holder.Grade.setText(form_1_infoList.Grade);
        holder.Average.setText(form_1_infoList.Average);
        holder.Total.setText(form_1_infoList.Total);

        holder.button_mdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent intent = new Intent(context, Form1Term1Deatails.class);
                intent.putExtra("Agriculture",form_1_infoList.getAgriculture());
                intent.putExtra("Student Name",form_1_infoList.getStudentName());
                intent.putExtra("Biology",form_1_infoList.getBiology());
                intent.putExtra("Physics",form_1_infoList.getPhysics());
                intent.putExtra("English",form_1_infoList.getEnglish());
                intent.putExtra("Chemistry",form_1_infoList.getChemistry());
                intent.putExtra("Chichewa",form_1_infoList.getChichewa());
                intent.putExtra("Mathematics",form_1_infoList.getMathematics());
                intent.putExtra("Geography",form_1_infoList.getGeography());
                intent.putExtra("SocialStudies",form_1_infoList.getSocialStudies());
                intent.putExtra("Grade",form_1_infoList.getGrade());
                intent.putExtra("Average",form_1_infoList.getAverage());
                intent.putExtra("Total",form_1_infoList.getTotal());

                context.startActivity(intent);




            }
        });





    }

    @Override
    public int getItemCount() {
        return form1s.size();
    }

    public void filterList(ArrayList<Form1> filteredList) {
        form1s = filteredList;
        notifyDataSetChanged();
    }





    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView StudentName,Total,Average,Grade;

        ImageButton button_mdetail;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            StudentName = (TextView) itemView.findViewById(R.id.m_student);

            Total= (TextView) itemView.findViewById(R.id.m_total);
            Average= (TextView) itemView.findViewById(R.id.m_average);
            Grade= (TextView) itemView.findViewById(R.id.m_grade);


            button_mdetail = (ImageButton) itemView.findViewById(R.id.button_m_detail);

        }
    }
}
