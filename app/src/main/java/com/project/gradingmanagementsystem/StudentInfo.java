package com.project.gradingmanagementsystem;

public class StudentInfo {

    String FullName,Phone,DOB,Address,Year,StudentID;

    public StudentInfo(){}

    public StudentInfo(String fullName, String phone, String DOB, String address, String year, String studentID) {
        this.FullName = fullName;
        this.Phone = phone;
        this.DOB = DOB;
        this.Address = address;
        this.Year = year;
        this.StudentID = studentID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }
}
