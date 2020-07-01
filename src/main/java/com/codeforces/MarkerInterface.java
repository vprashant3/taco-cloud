package com.codeforces;


public class MarkerInterface extends Deletabale {

    public void delete(Object o) throws Exception {
        if( !(o instanceof  Deletabale)) throw new Exception();
    }
}
