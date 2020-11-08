package com.AlogrithmsAndDataStructures.Recursion;


public class KathSymbolInGrammar {

    public static void main(String[] args) {
        System.out.println(new KathSymbolInGrammar().kthGrammar(2, 2));
    }

    public int kthGrammar(int N, int K) {
        if(N == 1 && K == 1) {
            return 0;
        }
        int length = (int)Math.pow(2, N - 1);
        int mid = length/2;
        if(K <= mid) {
            return kthGrammar(N - 1, K);
        } else {
            return kthGrammar(N - 1, K - mid) == 0 ? 1 : 0;
        }
    }
}
