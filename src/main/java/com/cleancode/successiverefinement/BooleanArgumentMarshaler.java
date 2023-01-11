package com.cleancode.successiverefinement;

public class BooleanArgumentMarshaler extends ArgumentMarshaler {
    private boolean booleanValue = false;
    public void setBoolean(boolean value) {
        booleanValue = value;
    }
    public boolean getBoolean() {return booleanValue;}
}
