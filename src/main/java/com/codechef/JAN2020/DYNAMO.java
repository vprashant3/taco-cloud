package com.codechef.JAN2020;

import java.util.Scanner;

public class DYNAMO {

    public static void main (String[] args) throws java.lang.Exception
    {
        try {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            for (int i = 0; i < T; i++) {
                long N = sc.nextLong();
                long A = sc.nextLong();
                long Max = (long) Math.pow(10,N);
                long S = (2*Max)+A;
                System.out.println(S);
                long B = sc.nextLong();
                long C = Max - B;
                System.out.println(C);
                long D = sc.nextLong();
                long E = Max - D;
                System.out.println(E);
                int res = sc.nextInt();
                if(res == -1) return;
            }
        } catch (Exception e) {

        }


    }
}
