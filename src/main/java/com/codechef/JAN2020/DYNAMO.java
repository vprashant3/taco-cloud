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
                int S = (4*(int)(Math.pow(10,N))+A)/2;
                System.out.println(S);
                System.out.flush();
                int B = sc.nextInt();
                int C = (S - (A+B)) > ((int)Math.pow(10,N)-1)?((int)Math.pow(10,N)-1) : (S - (A+B));
                System.out.println(C);
                System.out.flush();
                int D = sc.nextInt();
                int E = S-(A+B+C+D);
                E = E>((int)Math.pow(10,N)-1)?((int)Math.pow(10,N)-1) : E;
                System.out.println(E);
                System.out.flush();
                int res = sc.nextInt();
                if(res == -1) System.exit(0);
            }
        } catch (Exception e) {

        }

    }
}
