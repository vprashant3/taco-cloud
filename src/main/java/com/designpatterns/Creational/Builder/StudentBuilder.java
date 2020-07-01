package com.designpatterns.Creational.Builder;

public class StudentBuilder {

    //Required
    private int rollNo;
    private String name;

    //Optional
    private int phoneNo;
    private String Address;

    public StudentBuilder(int rollNo, String name) {
        this.rollNo =  rollNo;
        this.name  = name;
    }

    public StudentBuilder setPhoneNumber(int phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public StudentBuilder setAddress(String Address) {
        this.Address = Address;
        return this;
    }


    public Student build() {
        Student student = new Student(this);
        return student;
    }

}
