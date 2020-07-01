package com.codeforces;

import java.util.HashSet;
import java.util.Objects;

final public class Map {
    final public int i;
    final public int j;
    final public int k;

    public Map(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public static void main(String[] args) {
        Map m1 = new Map(1,2,3);
        Map m2 = new Map(1,2, 4);
        Map m3 = new Map(2,1,5);
        HashSet<Map> s = new HashSet();
        s.add(m1);
        s.add(m2);
        s.add(m3);
        System.out.println(s.size());
        Map m4 = new Map(2, 1,3);
        s.add(m4);
        System.out.println(s.size());


    }

    @Override
    public boolean equals(Object o) {
       return o.equals(this.k);
    }

    @Override
    public int hashCode() {
        return (i*j)+k;
    }
}
