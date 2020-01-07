package com.codechef.JAN2020;

import java.util.Scanner;

public class DOREMON {

    public static void main (String[] args) throws java.lang.Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            for (int t = 0; t < T; t++) {
                int N = sc.nextInt();
                int M = sc.nextInt();
                int[][] matrix = new int[N][M];
                int res = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        matrix[i][j] = sc.nextInt();
                    }
                }

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        res += findAllPaindromesAtThisPoint(matrix, i, j, N, M);
                    }
                }
                System.out.println(res);
            }

        } catch (Exception e) {

        }
    }

    private static int findAllPaindromesAtThisPoint(int[][] matrix,int i, int j, int N, int M) {
        int counter = 0;
        while(true) {
            if(i-counter>=0 && i+counter<N && j-counter>=0 && j+counter<M) {
                if(matrix[i-counter][j] == matrix[i+counter][j] && matrix[i][j-counter] == matrix[i][j+counter]) {
                    counter++;
                }
                else break;
            }else break;
        }
        return counter;
    }
}
