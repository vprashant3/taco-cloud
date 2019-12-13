package com.codechef;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import io.swagger.models.auth.In;

import java.util.Scanner;

public class BINADD {

    public static void main (String[] args) throws java.lang.Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int numTestCases = sc.nextInt();

            for (int i = 0; i < numTestCases; i++) {
                String A_str = sc.next();
                String B_Str = sc.next();
                int A = Integer.parseInt(A_str,2);
                int B = Integer.parseInt(B_Str,2);
                int numOfLoops = 0;
                if(B == 0) System.out.println(numOfLoops);
                else {
                    while (B != 0) {
                        numOfLoops++;
                        int U = (A | B) & (~A | ~B);
                        int V = (A & B);
                        A = U;
                        B = V*2;

                    }
                    System.out.println(numOfLoops);
                }


            }

        } catch (Exception e) {
            throw new Exception();
        }
    }
}
