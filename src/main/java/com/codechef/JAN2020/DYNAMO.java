package com.codechef.JAN2020;

import java.util.Scanner;

public class DYNAMO {

    public static void main (String[] args) throws java.lang.Exception
    {
        try {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            for (int i = 0; i < T; i++) {
                int N = sc.nextInt();
                int A = sc.nextInt();
                int Max = (int) Math.pow(10,N);
                int S = (2*Max)+A;
                System.out.println(S);
                int B = sc.nextInt();
                int C = Max - B;
                System.out.println(C);
                int D = sc.nextInt();
                int E = Max - D;
                System.out.println(E);
                int res = sc.nextInt();
                if(res == -1) return;
            }
        } catch (Exception e) {

        }


    }
}
