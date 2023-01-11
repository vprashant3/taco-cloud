package com.cleancode.successiverefinement;

public class StringArgumentMarshaler extends ArgumentMarshaler {
    private String stringValue = "";
    public void setString(String value) {
        stringValue = value;
    }
    public String getString() {return stringValue;}
}
