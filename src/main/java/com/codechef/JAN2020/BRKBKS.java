package com.codechef.JAN2020;

import java.util.Scanner;

public class BRKBKS {

    public static void main (String[] args) throws java.lang.Exception
    {
        try {
            Scanner sc = new Scanner(System.in);
            int numTestCases = sc.nextInt();

            for (int i = 0; i < numTestCases; i++) {
                int str = sc.nextInt();
                int w1 = sc.nextInt();
                int w2 = sc.nextInt();
                int w3 = sc.nextInt();

                if (w1 + w2 + w3 <= str) System.out.println(1);
                else if (w1 + w2 <= str || w2 + w3 <= str) System.out.println(2);
                else System.out.println(3);


            }
        } catch (Exception e) {
            throw new Exception();
        }

    }

}
