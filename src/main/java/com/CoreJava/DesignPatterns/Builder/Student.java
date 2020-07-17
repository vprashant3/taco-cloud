package com.CoreJava.DesignPatterns.Builder;

public class Student {

    //Required
    private int rollNo;
    private String name;

    //Optional
    private int phoneNo;
    private String Address;

    public Student(StudentBuilder studentBuilder) {
        this.rollNo = rollNo;
        this.name = name;
        this.phoneNo = phoneNo;
        this.Address = Address;
    }
}
