package com.codechef.JAN2020;

import java.util.Scanner;

public class ISBIAS {


    public static void main (String[] args) throws java.lang.Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int Q = sc.nextInt();
            int[] A = new int[N];

            for(int i=0; i<N; i++) {
                A[i] = sc.nextInt();
            }

            for(int i =0; i<Q; i++) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                int maximal = 0;
                int minimal = 0;
                for(int j=L-1;j<R; j++) {
                    int counter = 0;
                    while(j+counter < N && A[j+counter]<A[j+counter+1]) {
                        if(counter >= L && counter <=R) maximal++;
                        counter++;
                    }
                    counter = 0;
                    while(j+counter < N && A[j+counter]>A[j+counter+counter]) {
                        if(counter >= L && counter <=R) minimal++;
                        counter++;
                    }

                }
                System.out.println("here");
                if(maximal == minimal) {
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        } catch ( Exception e) {
            System.out.println("exceptions");
        }
    }
}
