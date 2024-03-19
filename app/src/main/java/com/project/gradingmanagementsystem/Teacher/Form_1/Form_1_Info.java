package com.project.gradingmanagementsystem.Teacher.Form_1;

public class Form_1_Info {

    String Date;
    String sClass;
    String Term;
    String Teacher;
    public String StudentName;
    public String Agriculture;
    public String Biology;
    public String Chemistry;
    public String Chichewa;
    String English;
    public String Geography;
    public String Mathematics;
    public String Physics;
    public String SocialStudies;
    public String Total;
    public String Average;
    public String Grade;
    public Form_1_Info(){}

    public Form_1_Info(String date, String sClass, String term, String teacher, String studentName, String agriculture, String biology, String chemistry, String chichewa, String english, String geography, String mathematics, String physics, String socialStudies, String total, String average, String grade) {

        this.Date = date;
        this.sClass = sClass;
        this.Term = term;
        this.Teacher = teacher;
        this.StudentName = studentName;
        this.Agriculture = agriculture;
        this.Biology = biology;
        this.Chemistry = chemistry;
        this.Chichewa = chichewa;
        this.English = english;
        this.Geography = geography;
        this.Mathematics = mathematics;
        this.Physics = physics;
        this. SocialStudies = socialStudies;
        this.Total = total;
        this.Average = average;
        this.Grade = grade;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getAgriculture() {
        return Agriculture;
    }

    public void setAgriculture(String agriculture) {
        Agriculture = agriculture;
    }

    public String getBiology() {
        return Biology;
    }

    public void setBiology(String biology) {
        Biology = biology;
    }

    public String getChemistry() {
        return Chemistry;
    }

    public void setChemistry(String chemistry) {
        Chemistry = chemistry;
    }

    public String getChichewa() {
        return Chichewa;
    }

    public void setChichewa(String chichewa) {
        Chichewa = chichewa;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String english) {
        English = english;
    }

    public String getGeography() {
        return Geography;
    }

    public void setGeography(String geography) {
        Geography = geography;
    }

    public String getMathematics() {
        return Mathematics;
    }

    public void setMathematics(String mathematics) {
        Mathematics = mathematics;
    }

    public String getPhysics() {
        return Physics;
    }

    public void setPhysics(String physics) {
        Physics = physics;
    }

    public String getSocialStudies() {
        return SocialStudies;
    }

    public void setSocialStudies(String socialStudies) {
        SocialStudies = socialStudies;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getAverage() {
        return Average;
    }

    public void setAverage(String average) {
        Average = average;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }
}
