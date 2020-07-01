package com.codeforces;

public class BindingExample {

     static class SuperClass {
        public static void staticPrint() {
            System.out.println("in static print SuperClass");
        }
         public void dynamicPrint() {
             System.out.println("in dynamic print SuperClass");
         }
     }

    static class SubClass extends SuperClass {
        public static void staticPrint() {
            System.out.println("in static print SubClass");
        }
        public void dynamicPrint() {
            System.out.println("in dynamic print SubClass");
        }
     }

    public static void main(String[] args) {
        SuperClass s1 = new SuperClass();
        SuperClass s2 = new SubClass();
        s2.dynamicPrint();
        s2.staticPrint();

    }
}
