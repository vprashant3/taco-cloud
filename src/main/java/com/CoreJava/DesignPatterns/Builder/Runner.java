package com.CoreJava.DesignPatterns.Builder;

public class Runner {
    public static void main(String[] args) {
        StudentBuilder sb1 =  new StudentBuilder(1, "name1");
        sb1.setPhoneNumber(223);
        final Student build = sb1.build();
    }
}
