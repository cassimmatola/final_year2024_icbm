package com.project.gradingmanagementsystem.Form2Adapters;

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
import com.project.gradingmanagementsystem.Form1Adapters.Form1Term3Details;
import com.project.gradingmanagementsystem.R;

import java.util.ArrayList;

public class Form2Term3 extends RecyclerView.Adapter< Form2Term3 .MyViewHolder>{

    private Context context;

    private  ArrayList<Form2_3> form2_3s;
    FirebaseFirestore fStore;


    public Form2Term3(Context context, ArrayList<Form2_3> form2_3s) {
        this.context = context;
        this.form2_3s = form2_3s;
        this.fStore = fStore;
    }

    @NonNull
    @Override
    public Form2Term3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        int layoutResId;

        // Choose the appropriate layout based on the viewType
        switch (viewType) {
            case 0:
                layoutResId = R.layout.one_term_1_item;
                break;
            case 1:
                layoutResId = R.layout.one_term_2_item;
                break;
            case 2:
                layoutResId = R.layout.one_term_3_item;
                break;
            case 3:
                layoutResId = R.layout.two_term_1_item;
                break;
            case 4:
                layoutResId = R.layout.two_term_2_item;
                break;
            case 5:
                layoutResId = R.layout.two_term_3_item;
                break;
            case 6:
                layoutResId = R.layout.three_term_1_item;
                break;
            case 7:
                layoutResId = R.layout.three_term_2_item;
                break;
            case 8:
                layoutResId = R.layout.three_term_3_item;
                break;
            case 9:
                layoutResId = R.layout.four_term_1_item;
                break;
            case 10:
                layoutResId = R.layout.four_term_2_item;
                break;
            case 11:
                layoutResId = R.layout.four_term_3_item;
                break;
            default:
                layoutResId = R.layout.default_item;  // Provide a default layout
                break;
        }

        // Inflate the chosen view
        v = LayoutInflater.from(context).inflate(layoutResId, parent, false);

        // Return a MyViewHolder with the inflated view
        return new Form2Term3.MyViewHolder(v);
    }





    @Override
    public void onBindViewHolder(@NonNull final Form2Term3.MyViewHolder holder, int position) {
        fStore=FirebaseFirestore.getInstance();

        final Form2_3 form_1_infoList = form2_3s.get(position);

        holder.StudentName.setText(form_1_infoList.StudentName);
        holder.Grade.setText(form_1_infoList.Grade);
        holder.Average.setText(form_1_infoList.Average);
        holder.Total.setText(form_1_infoList.Total);

        holder.mdetail4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Form1Term3Details.class);
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
        return form2_3s.size();
    }

    public void filterList(ArrayList<Form2_3> filteredList) {
        form2_3s = filteredList;
        notifyDataSetChanged();
    }





    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView StudentName,Total,Average,Grade;
        ImageButton mdetail4;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            StudentName = itemView.findViewById(R.id.m_student);
            Total=itemView.findViewById(R.id.m_total);
            Average=itemView.findViewById(R.id.m_average);
            Grade= itemView.findViewById(R.id.m_grade);
            mdetail4 = itemView.findViewById(R.id.button_m_detail);

        }
    }

}
